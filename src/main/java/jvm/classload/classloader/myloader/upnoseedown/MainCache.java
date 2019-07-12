package jvm.classload.classloader.myloader.upnoseedown;

import jvm.classload.classloader.myloader.MyClassLoader;

/**
 * 结论：
 * {
 *     不同 类加载器实例 缓存的类对象，互相隔离
 *     类加载器实例 对类对象 的缓存是分块的，不是统一的
 * }
 * 验证：同一委派链上，下层 类加载器实例 所缓存的Class对象，对于上层加载器所加载的类仍然是不可见的。
 *
 * 操作：编译后，将jvm包整体放在桌面上，删掉classpath下的:
 * {
 *     jvm.classload.classloader.myloader.upnoseedown.Low.class
 *     jvm.classload.classloader.myloader.upnoseedown.High.class
 * }
 * 目的：使其（Low.class、High.class）通过自定义类加载器加载；
 * console：
 * {
 *      MainCache :sun.misc.Launcher$AppClassLoader@18b4aac2
 *      ---> I am loading : jvm.classload.classloader.myloader.upnoseedown.Low
 *      my loader cache : class jvm.classload.classloader.myloader.upnoseedown.Low
 *      my loader parent : sun.misc.Launcher$AppClassLoader@18b4aac2
 *      in Low : jvm.classload.classloader.myloader.MyClassLoader@135fbaa4
 *      ---> I am loading : jvm.classload.classloader.myloader.upnoseedown.High
 *      in High : jvm.classload.classloader.myloader.MyClassLoader@135fbaa4
 *      getClsLder from High: jvm.classload.classloader.myloader.MyClassLoader@135fbaa4
 *      in constructor Low
 *      in constructor Low
 * }
 * 结论：同一 类加载器实例 所加载的类互相可见，且已入缓存
 *
 * 重新编译：
 * 操作：将以下这两行放在 c.newInstance(); 下面
 * {
 *     System.out.println("my loader cache : " + pClassLoader.getCacheClassFromJVM(ClassName));
 *     System.out.println("my loader parent : " + pClassLoader.getParent());
 * }
 * 直接执行：
 * {
 *      MainCache :sun.misc.Launcher$AppClassLoader@18b4aac2
 *      in Low : sun.misc.Launcher$AppClassLoader@18b4aac2
 *      in High : sun.misc.Launcher$AppClassLoader@18b4aac2
 *      getLowClsLder from High: sun.misc.Launcher$AppClassLoader@18b4aac2
 *      in constructor Low
 *      in constructor Low
 *      my loader cache : null
 *      my loader parent : sun.misc.Launcher$AppClassLoader@18b4aac2
 * }
 * 结论：子（Usr） 加载器实例 访问不到 父 类加载器实例（App）的缓存的类对象
 *
 *重新编译：
 * 操作：编译后，将jvm包整体放在桌面上，删掉classpath下的:
 * {
 *     jvm.classload.classloader.myloader.upnoseedown.Low.class
 * }
 * 目的：使其（Low.class）通过自定义类加载器加载；
 * {
 *      MainCache :sun.misc.Launcher$AppClassLoader@18b4aac2
 *      ---> I am loading : jvm.classload.classloader.myloader.upnoseedown.Low
 *      my loader cache : class jvm.classload.classloader.myloader.upnoseedown.Low
 *      my loader parent : sun.misc.Launcher$AppClassLoader@18b4aac2
 *      in Low : jvm.classload.classloader.myloader.MyClassLoader@135fbaa4
 *      sun.misc.Launcher$AppClassLoader@18b4aac2
 *      Exception in thread "main" in High :
 *      java.lang.NoClassDefFoundError: jvm/classload/classloader/myloader/upnoseedown/Low
 *      Caused by: java.lang.ClassNotFoundException: jvm.classload.classloader.myloader.upnoseedown.Low
 * }
 * 结论：父 类加载器实例（App） 访问不到 子 加载器实例（Usr）的缓存的类对象
 */
public class MainCache {

    static {
        System.out.println("MainCache :"+ MainCache.class.getClassLoader());
    }
    private static final String ClassName = "jvm.classload.classloader.myloader.upnoseedown.Low";

    public static void main(String[] args) throws Exception{
        MyClassLoader pClassLoader=new MyClassLoader("C:\\Users\\top37\\Desktop\\");
        //包名+类名
        Class c=pClassLoader.loadClass(ClassName);

        c.newInstance();
        System.out.println("my loader cache : " + pClassLoader.getCacheClassFromJVM(ClassName));
        System.out.println("my loader parent : " + pClassLoader.getParent());

    }
}
