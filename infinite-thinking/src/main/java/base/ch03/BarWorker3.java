package base.ch03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class BarWorker3 implements Runnable {

    private static AtomicBoolean exists = new AtomicBoolean(false);

    private String name;

    public BarWorker3(String name) {
        this.name = name;
    }

    public void run() {
        if (exists.compareAndSet(false, true)) {
            System.out.println(name + " enter");
            try {
                System.out.println(name + " working");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // do nothing
            }
            System.out.println(name + " leave");
            exists.set(false);
        }else{
            System.out.println(name + " give up");
        }
    }

    public static void main(String[] args) {

        BarWorker3 work1 = new BarWorker3("bar1");
        BarWorker3 work2 = new BarWorker3("bar2");

        Thread t1 = new Thread(work1);
        Thread t2 = new Thread(work2);

        t1.start();
        t2.start();

    }

}

