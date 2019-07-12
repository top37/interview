package jvm.classload.classloader.myloader.data;

public class HighClass {
    static {
        System.out.println("in HighClass : " + HighClass.class.getClassLoader());
//        new LowClass();
    }

    private static InterfcPara para;

    public static void getDown(Object param){
        System.out.println("in getDown");
        para = (InterfcPara)param;
//        this.para = param;
    }
}
