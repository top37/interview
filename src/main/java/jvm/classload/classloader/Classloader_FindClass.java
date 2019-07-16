package jvm.classload.classloader;

import java.io.InputStream;

/**
 * -verbose:class
 * 推荐，符合双亲委派
 * 委派给AppClassloader时，发现此类（在JVM的缓存：SystemDictionary中），直接返回，并没有调用重写的findClass方法；
 */
public class Classloader_FindClass {
    static {
        System.out.println( "Classloader_FindClass 的loader是："+Classloader_FindClass.class.getClassLoader() );
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myCld = new ClassLoader(null) {
            @Override
            public Class<?> findClass(String name) throws ClassNotFoundException {

                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    System.out.println("-->" + fileName);
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };
        //委派给AppClassloader时，发现此类（在JVM的缓存：SystemDictionary中），直接返回，并没有调用重写的findClass方法；
        Class cls = myCld.loadClass("jvm.classload.classloader.Classloader_FindClass");

        cls.newInstance();
//        new ClassloaderMain();

//        Object obj = cls.newInstance();
//        Object obj1 = new Classloader_FindClass();


//        System.out.println(obj instanceof Classloader_FindClass);
//        System.out.println(obj1 instanceof Classloader_FindClass);
//        System.out.println(obj.getClass());
    }
}
