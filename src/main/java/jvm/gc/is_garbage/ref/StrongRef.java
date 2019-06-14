package jvm.gc.is_garbage.ref;

/**
 * 只要强引用在，垃圾搜集器永远不会搜集被引用的对象。
 * 也就是说，宁愿出现内存溢出，也不会回收这些对象。
 */
public class StrongRef {

    private static int _1MB = 1024*1024;
    private byte[] bigSize = new byte[2*_1MB];

    public static void main(String[] args) {
        StrongRef[] StrongRefArr = new StrongRef[1000];
    }

    public static void fun1() {
        Object object = new Object();
        StrongRef[] StrongRefArr = new StrongRef[1000];
        System.gc();
    }
}
