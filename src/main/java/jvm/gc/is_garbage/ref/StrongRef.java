package jvm.gc.is_garbage.ref;

/**
 * 只要强引用在，垃圾搜集器永远不会搜集被引用的对象。
 * 也就是说，宁愿出现内存溢出，也不会回收这些对象。
 */
public class StrongRef {
    public static void main(String[] args) {
        Object obj = new Object();
    }
}
