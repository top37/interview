package jvm.gc.is_garbage.ref.refqueue;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * ReferenceQueue的意义在于，可以对实例的状态进行监控：
 * 如果有obj被回收，那么相应的ref就会被放入ReferenceQueue中；
 */
public class RefQueueMain {
    private static ReferenceQueue<NomalObj> rq = new ReferenceQueue<>();

    private static void checkQueue(){
        Reference<NomalObj> ref;

        while (( ref = (Reference<NomalObj>)rq.poll() )!= null){
                System.out.println("in queue ref: "+ ((NomalObjWeakRef)(ref)).name);
                System.out.println("obj :" + ref.get());
        }

        System.out.println("check over---");
    }

    public static void main(String[] args) throws InterruptedException {
        List<WeakReference<NomalObj>> lstWeakRefObj = new ArrayList<>();
        for(int i = 1; i <= 3;i++){
            lstWeakRefObj.add(new NomalObjWeakRef(new NomalObj("weak "+i),rq));
            System.out.println("Create Weak :" + lstWeakRefObj.get(i-1));
        }
        System.out.println("first time---");
        checkQueue();

        System.gc();
        Thread.sleep(1000);

        System.out.println("second time---");
        checkQueue();
    }

}
