package jvm.classload.classloader.myloader.data;

public class LowClass implements InterfcPara{

    static {
        System.out.println("in LowClass : "+LowClass.class.getClassLoader());
    }

    public LowClass(){
        System.out.println("in constructor LowClass");
    }

}
