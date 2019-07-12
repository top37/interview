package jvm.classload.classloader.demo;

import java.sql.Driver;

public class GrandPaClass {

    static {
        System.out.println("GrandPaClass 的loader ：" + GrandPaClass.class.getClassLoader());

        System.out.println("dr 的loader ："+ Driver.class.getClassLoader());
    }
}
