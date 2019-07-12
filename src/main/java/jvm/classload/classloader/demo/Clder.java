package jvm.classload.classloader.demo;

public abstract class Clder {

    public Object loadCls(String str){
        return loadCls(str,false);
    }

    public Object loadCls(String str,boolean b){
        System.out.println("6666666666"+str);
        return null;
    }
}
