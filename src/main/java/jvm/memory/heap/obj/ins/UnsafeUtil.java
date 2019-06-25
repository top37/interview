package jvm.memory.heap.obj.ins;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

public class UnsafeUtil {

    private final static Unsafe THE_UNSAFE;
    // 只能通过反射获取Unsafe对象的实例
    static{
        try {
            final PrivilegedExceptionAction<Unsafe> action = new PrivilegedExceptionAction<Unsafe>() {
                public Unsafe run() throws Exception {
                    Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                    theUnsafe.setAccessible(true);
                    return (Unsafe) theUnsafe.get(null);
                }
            };
            THE_UNSAFE = AccessController.doPrivileged(action);
        }
        catch (Exception e){
            throw new RuntimeException("Unable to load unsafe", e);
        }
    }

    public static void main(String[] args) {
        Field[] fields = ObjectA.class.getDeclaredFields();
        for(Field field : fields) {
            System.out.println(field.getName() + "---offSet:" + THE_UNSAFE.objectFieldOffset(field));
        }
    }

}
