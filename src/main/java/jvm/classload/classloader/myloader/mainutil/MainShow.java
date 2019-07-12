package jvm.classload.classloader.myloader.mainutil;

import jvm.classload.classloader.myloader.Main;

/**
 * sun.boot.class.path
 * java.ext.dirs
 * java.class.path
 */
public class MainShow {
    public static void main(String[] args) {
        ClassLoader loader = Main.class.getClassLoader();

        while ( null != loader ){
           System.out.println(loader);
           loader = loader.getParent();
       }
        System.out.println(loader);
    }
}
