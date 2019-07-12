package jvm.classload.classloader.myloader.upnoseedown;

import jvm.classload.classloader.myloader.MyClassLoader;

/**
 * 操作：编译后，将jvm包整体放在桌面上，删掉classpath下的：jvm.classload.classloader.myloader.upnoseedown.Low.class；
 * 目的：使其（Low.class）通过自定义类加载器加载；
 * 已知：
 * {
 *     通过重写findClass()方法，并没有破坏双亲委派，
 *     自定义的类加载器（MyClassLoader pClassLoader）其仍然在委派链上，
 *     其父加载器默认为：SystemClassLoader()；
 * }
 */
public class Main2 {

    static {
        System.out.println("Main2 :"+ Main2.class.getClassLoader());
    }
    private static final String ClassName = "jvm.classload.classloader.myloader.upnoseedown.Low";
    public static void main(String[] args) throws Exception{
        MyClassLoader pClassLoader=new MyClassLoader("C:\\Users\\top37\\Desktop\\");
        //包名+类名
        Class c=pClassLoader.loadClass(ClassName);
        c.newInstance();

    }
}
