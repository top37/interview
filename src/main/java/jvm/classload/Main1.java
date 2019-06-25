package jvm.classload;

//import static jvm.classload.Child0.ci;

public class Main1 {

    public static void main(String[] args) {
        System.out.println(new Child0().ci);
        String str0 = "sq666";
        String str = "sq"+"666";
        String str1 = new String("sq666");
        System.out.println(Parent0.pi);
        System.out.println(str1.intern() == str);
        System.out.println("==============");
        final String s1 = "sqq";
        final String s2 = "sqqtest";
        String s3 = s1+s2;
        System.out.println("==============");
        String s11 = "sqq";
        String s22 = "sqqtest";
        String s33 = s11+s22;
        System.out.println("==============");
    }
}

class Parent0 {
    static int pi = 2;
    static {
        System.out.println("Parent0 init");
    }
}

class Child0 {
    final int ci = 1;
}
