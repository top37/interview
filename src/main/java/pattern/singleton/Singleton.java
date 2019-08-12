package pattern.singleton;

/**
 * DCL：双锁检测
 * Q:这两层 null 校验分别有什么作用？
 * A：第一层：非首次使用（单例已实例化），直接返回引用；
 *    第二层：首次使用，禁止其他线程访问；当首线程处理完后，s已被赋值，故而其他线程判断s为null则直接返回s
 *
 *  DCL在jdk1.5之后 已经不存在new 一个对象的指令重排序问题了；
 *  所以1.6以及以后的Java sdk 不需要volatile 关键字的保护了
 *
 *  指令重排？
 *  JVM规范规定，在不影响单线程程序执行结果前提下 可以进行 指令重新排序。
 *  指令重排序是JVM为了优化指令，提高程序运行效率。
 *  指令重排序包括编译器重排序和运行时重排序。
 *
 */
public class Singleton {
    //volatile:其他线程可见、禁止指令重排序
    private static Singleton s;
    private Singleton(){}

    public static Singleton getSingleton(){
        if(s == null){
            synchronized (Singleton.class){
                if(s == null){
                    s = new Singleton();
                }
            }
        }
        return s;
    }
}
