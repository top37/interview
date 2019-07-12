package jvm.classload.classloader.myloader.scl.da;

public class Down {
    static {
        System.out.println("init down's loader : "+ Down.class.getClassLoader());
        new Up();
    }

    public Down(){
        System.out.println("contructor down's loader : "+ Down.class.getClassLoader());
    }


}
