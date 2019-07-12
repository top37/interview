package jvm.classload.classloader.myloader.upnoseedown;

public class High {
    static {
        System.out.println("in High : " + High.class.getClassLoader());
        System.out.println("getLowClsLder from High: " + Low.class.getClassLoader());
        new Low();
    }

}
