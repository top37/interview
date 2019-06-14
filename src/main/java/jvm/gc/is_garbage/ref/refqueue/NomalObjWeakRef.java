package jvm.gc.is_garbage.ref.refqueue;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class NomalObjWeakRef extends WeakReference<NomalObj> {

    public String name;

    public NomalObjWeakRef(NomalObj nomalObj, ReferenceQueue<NomalObj> q) {
        super(nomalObj, q);
        this.name = nomalObj.name;
    }

    @Override
    protected void finalize(){
        //未触发，证明没有被回收掉
        System.out.println("finalize NomalObjWeakRef "+ name);
    }
}
