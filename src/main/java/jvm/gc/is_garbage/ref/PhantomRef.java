package jvm.gc.is_garbage.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用和前面的软引用、弱引用不同，它并不影响对象的生命周期。
 * 在java中用java.lang.ref.PhantomReference类表示。
 * 如果一个对象与虚引用关联，则跟没有引用与之关联一样，在任何时候都可能被垃圾回收器回收。
 * 要注意的是，虚引用必须和引用队列关联使用，当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，就会把这个虚引用加入到与之 关联的引用队列中。
 * 程序可以通过判断引用队列中是否已经加入了虚引用，来了解被引用的对象是否将要被垃圾回收。
 * 如果程序发现某个虚引用已经被加入到引用队列，那么就可以在所引用的对象的内存被回收之前采取必要的行动。
 *
 * 虚引用中有一个构造函数，可以看出，其必须和一个引用队列一起存在。
 * get()方法永远返回null，因为虚引用永远不可达。
 *
 * 起到哨兵作用
 */
public class PhantomRef {
    public static void main(String[] args) {
        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);
        System.out.println(pr.get());
        System.out.println(queue);
    }
}
