package jvm.classload.classloader.myloader.mainutil;

/**
 *  Exception in thread "main" java.lang.StackOverflowError
 */
public class MainConstructorSelf {

    public MainConstructorSelf(){
        System.out.println("init");
        new MainConstructorSelf();
    }

    public static void main(String[] args) {
        new MainConstructorSelf();
    }
}
