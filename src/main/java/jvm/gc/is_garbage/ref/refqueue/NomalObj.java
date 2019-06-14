package jvm.gc.is_garbage.ref.refqueue;

public class NomalObj {
    public String name;

    public NomalObj(String name) {
        this.name = name;
    }

    @Override
    protected void finalize(){
        //触发，证明被回收掉了
        System.out.println("finalize NomalObj "+ name);
    }
}
