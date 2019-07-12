package jvm.classload.classloader.demo;

public class SonClass{

    static {
        System.out.println("SonClass 的loader ：" + SonClass.class.getClassLoader());

//        System.out.println("dr 的loader ："+ Driver.class.getClassLoader());
    }
}
