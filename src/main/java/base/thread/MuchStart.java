package base.thread;

/**
 * 根本原因：同一个对象，同一时刻不可能存在两种状态（属性值不可能出现两个值）；
 */
public class MuchStart implements Runnable{ //实现Runnable接口
    public void run() {
        System.out.println(Thread.currentThread().getName() + "is running ...");
    }

    public static void main(String[] args) throws InterruptedException {
        MuchStart muchStart = new MuchStart();
        Thread t = new Thread(muchStart);//创建实现了Runnable接口的Thread实例
        t.start();//多次调用start()方法
        Thread.sleep(1000);
        while(t.isAlive()){
            Thread.sleep(1000);
            System.out.println("I'm alive");
        }
        Thread.sleep(1000);
        t.start();
//        t.start();
    }
}
