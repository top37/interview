package jvm.classload.init.init01;

public class ClassInitTestMain {
    public static void main(String[] args) {
        ClassInit ci = ClassInit.getSingleton();
        System.out.println("count1 : "+ci.counter1);
        System.out.println("count1 : "+ci.counter2);
    }
}
