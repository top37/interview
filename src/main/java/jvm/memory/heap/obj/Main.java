package jvm.memory.heap.obj;

//import static jvm.memory.heap.obj.SizeOfObject.sizeOf;

import jvm.memory.heap.obj.ins.ObjectA;

import static feeler.SizeOfObject.sizeOf;

/**
 * -javaagent:mvn_pro/jagent-1.0.2-SNAPSHOT.jar
 * -XX:-UseCompressedOops
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ObjectA oaaaa = new ObjectA();
        System.out.println("Obj :"+ sizeOf(new ObjectA()));

        new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        },"sq").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i;
                int ii = 2;
                Integer j;
                Integer jj = 22;

                boolean b1;
                boolean b = false;
                while (true)
                {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"sq2").start();


    }
}
