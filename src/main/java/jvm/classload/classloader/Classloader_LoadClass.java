package jvm.classload.classloader;

import jvm.classload.classloader.demo.FatherClass;

import java.io.InputStream;

/**
 * -verbose:class
 * 不推荐：破坏双亲委派，JVM缓存中会出现两个相同的全路径名的实例
 */
public class Classloader_LoadClass extends FatherClass {
    static {
        System.out.println( "I am in" );
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myCld = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    System.out.println("-->" + fileName);
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Class cls = myCld.loadClass("jvm.classload.classloader.Classloader_LoadClass");
        Object obj = cls.newInstance();
        Object obj1 = new Classloader_LoadClass();
        System.out.println(obj instanceof Classloader_LoadClass);
        System.out.println(obj1 instanceof Classloader_LoadClass);
    }
}
