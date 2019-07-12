package jvm.classload.classloader.myloader.upnoseedown;

public class Low{

    static {
        System.out.println("in Low : "+ Low.class.getClassLoader());
        new High();
    }

    public Low(){
        System.out.println("in constructor Low");
    }

}
