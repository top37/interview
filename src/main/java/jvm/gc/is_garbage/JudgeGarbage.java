package jvm.gc.is_garbage;
/**
 * JVM运行参数： -XX:+PrintGC 打印GC日志
 * @author sq 2019年6月13日17:54:28
 */
public class JudgeGarbage {

    public Object instance = null;
    /**
     * 内存占位用，方便垃圾回收时从日志观察效果
     */
    private static int _1MB = 1024*1024;
    private byte[] bigSize = new byte[2*_1MB];

    public static void JudgeGarbageGC() {
        // 如果按照引用计数法，这里JudgeGarbage1，JudgeGarbage2创建时分别被引用一次，所以count1，count2都为1
        JudgeGarbage JudgeGarbage1 = new JudgeGarbage();
        JudgeGarbage JudgeGarbage2 = new JudgeGarbage();
        // 又被引用一次，count1，count2都为2
        JudgeGarbage1.instance = JudgeGarbage2;
        JudgeGarbage2.instance = JudgeGarbage1;
        // 分别取消引用一次，count1，count2都为1
        JudgeGarbage1 = null;
        JudgeGarbage2 = null;

        // 强制JVM进行垃圾回收
        System.gc();
    }

    public static void main(String[] args) {
        JudgeGarbageGC();
    }
}
