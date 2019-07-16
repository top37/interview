package jvm.classload.classloader.myloader.cache;

public class Bar {
    static {
        System.out.println("My Loader :"+Bar.class.getClassLoader() );
    }
}
