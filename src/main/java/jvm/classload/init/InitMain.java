package jvm.classload.init;

public class InitMain {
    static{
        i = 0;
//        System.out.println(i);//非法向前引用
    }

    static int i =1;

    public static void main(String[] args) {
        System.out.println(i);//1
    }
}
