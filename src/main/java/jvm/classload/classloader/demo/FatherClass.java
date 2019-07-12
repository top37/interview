package jvm.classload.classloader.demo;

import java.sql.Driver;

public class FatherClass extends GrandPaClass{

    static {
        System.out.println("FatherClass 的loader ：" + FatherClass.class.getClassLoader());
        new SonClass();
//        System.out.println("dr 的loader ："+ Driver.class.getClassLoader());
    }
}
