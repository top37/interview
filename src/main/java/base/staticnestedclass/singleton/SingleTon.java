package base.staticnestedclass.singleton;

/**
 * 优：延迟加载、线程安全
 * 缺：无法传参
 */
public class SingleTon {
    private SingleTon(){}

    private static class SingleTonHoler{
        private static SingleTon INSTANCE = new SingleTon();
    }

    public static SingleTon getInstance(){
        return SingleTonHoler.INSTANCE;
    }
}
