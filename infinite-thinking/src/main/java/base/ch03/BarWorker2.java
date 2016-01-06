package base.ch03;

import java.util.concurrent.TimeUnit;

public class BarWorker2 implements Runnable {

    private static boolean exists = false;

    private String name;

    public BarWorker2(String name) {
        this.name = name;
    }

    public void run() {
        if (!exists) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e1) {
                // do nothing
            }
            exists = true;
            System.out.println(name + " enter");
            try {
                System.out.println(name + " working");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // do nothing
            }
            System.out.println(name + " leave");
            exists = false;
        } else {
            System.out.println(name + " give up");
        }
    }

    public static void main(String[] args) {

        BarWorker2 work1 = new BarWorker2("bar1");
        BarWorker2 work2 = new BarWorker2("bar2");

        Thread t1 = new Thread(work1);
        Thread t2 = new Thread(work2);

        t1.start();
        t2.start();

    }

}

