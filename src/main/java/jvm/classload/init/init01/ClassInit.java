package jvm.classload.init.init01;

/**
 * 测试类加载及初始化顺序问题
 * <p>
 * Created by 单强 2019年7月9日12:53:28
 */

public class ClassInit {

    private static ClassInit singleton = new ClassInit();
    static int counter1;
    static int counter2 = 0;

    private ClassInit() {
        counter1++;
        counter2++;
    }

    public static ClassInit getSingleton() {
        return singleton;
    }

}
