package jvm.classload.classloader.myloader.scl.da;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/**
 * JDK8的@CallerSensitive
 * Reflection.getCallerClass()此方法的调用者必须有权限，需要什么样的权限呢？
 *  由bootstrap class loader加载的类可以调用
 *  由extension class loader加载的类可以调用
 * 都知道用户路径的类加载都是由 application class loader进行加载的，换句话说就是用户自定义的一些类中无法调用此方法
 */
public class Up {
    static {
        System.out.println("up's loader : "+ Up.class.getClassLoader());
        try {
//            ClassLoader.getSystemClassLoader().loadClass()
//            soutCaller();
            Class<?> c = Class.forName("jvm.classload.classloader.myloader.scl.da.Down",true,ClassLoader.getSystemClassLoader());

            //判断Down.class是否会放入app cls loader的缓存中
            // 结论：不会 ClassNotFoundException；并且很可能永远也不会被加到高层cls loader的缓存中，
            Class<?> c1 = Class.forName("jvm.classload.classloader.myloader.scl.da.Down");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    @CallerSensitive
//    public static void soutCaller(){
//        System.out.println("Up Reflection.getCallerClass :"+Reflection.getCallerClass());
//    }
}
