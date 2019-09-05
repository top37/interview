package base.thread;

/**
 * https://www.jianshu.com/p/4eeafa460729
 */
public class MainFinishBeforeThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        });

        t.start();
        Thread.sleep(1000);
        t.setName("aqiang");

        System.out.println("6666");
    }
}
