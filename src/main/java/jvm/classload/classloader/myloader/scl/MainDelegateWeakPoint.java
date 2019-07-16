package jvm.classload.classloader.myloader.scl;

import jvm.classload.classloader.myloader.scl.da.Down;

/**
 * -Djava.system.class.loader=jvm.classload.classloader.myloader.scl.MySysClassLoader -XX:+TraceClassLoading
 *
 * 目的：修改init classloader
 * 方法：
 * {
 *     通过以上参数,指定system classloader，那么会在runtime时，
 *     在main函数执行与rt.jar同时前，将 此加载器 的 字节码文件 加载
 * }
 * 操作：
 * 1.compile
 * 2.将MySysClassLoader 的classpath属性赋值为 C:\Users\top37\Desktop\
 * *注意：将MySysClassLoader需要有一个只含ClassLoader参数的构造方法：public MySysClassLoader(ClassLoader parent)
 * 3.复制target/classes/jvm(jvm包)到桌面
 * 4.删除相应classpath路径下 MainDelegateWeakPoint.class、Down.class字节码文件
 *
 * console：
 * ---> I am loading : jvm.classload.classloader.myloader.scl.MainDelegateWeakPoint
 * ---> I am cache : null
 * ---> I am cache obj: null
 * static MainDelegateWeakPoint :jvm.classload.classloader.myloader.scl.MySysClassLoader@55f96302
 * ---> I am loading : jvm.classload.classloader.myloader.scl.da.Down
 * ---> I am cache : null
 * ---> I am cache obj: class java.lang.Object
 * init down's loader : jvm.classload.classloader.myloader.scl.MySysClassLoader@55f96302
 * up's loader : sun.misc.Launcher$AppClassLoader@18b4aac2
 * java.lang.ClassNotFoundException: jvm.classload.classloader.myloader.scl.da.Down
 * 	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
 * 	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
 */
public class MainDelegateWeakPoint {
    static {
        System.out.println("static MainDelegateWeakPoint :"+ MainDelegateWeakPoint.class.getClassLoader());
    }

    public MainDelegateWeakPoint(){
        System.out.println("contructor MainDelegateWeakPoint :"+ MainDelegateWeakPoint.class.getClassLoader());
    }

    public static void main(String[] args) {

        new Down();
//        System.out.println("haha");
//        System.out.println(System.getProperty("java.system.class.loader"));
//        System.out.println(ClassLoader.getSystemClassLoader());
    }


}
