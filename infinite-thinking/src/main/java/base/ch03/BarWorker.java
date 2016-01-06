package base.ch03;

public class BarWorker implements Runnable {

    private static boolean exists = false;

    private String name;

    public BarWorker(String name) {
        this.name = name;
    }

    public void run() {
        if (!exists) {
            exists = true;
            System.out.println(name + " enter");
            System.out.println(name + " working");
            System.out.println(name + " leave");
            exists = false;
        } else {
            System.out.println(name + " give up");
        }
    }

    public static void main(String[] args) {

        BarWorker work1 = new BarWorker("bar1");
        BarWorker work2 = new BarWorker("bar2");

        Thread t1 = new Thread(work1);
        Thread t2 = new Thread(work2);

        t1.start();
        t2.start();

    }

}

