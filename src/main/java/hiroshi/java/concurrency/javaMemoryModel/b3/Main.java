package hiroshi.java.concurrency.javaMemoryModel.b3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main {
    private static final Random rnd = new Random(314159);

    public static void main(String[] args) throws InterruptedException {
        final Somthing sth = new Somthing();
        for (int i = 0; i < 100; i++) {
            doIt(sth, i);
            Thread.sleep(rnd.nextInt(100));
        }
    }

    private static void doIt(Somthing sth, int idx) {
        CountDownLatch latch = new CountDownLatch(2);
        final Thread w = new Thread(() -> {
            sth.write();
            latch.countDown();
        });
        final Thread r = new Thread(() -> {
            sth.write();
            latch.countDown();
        });
        w.start();
        r.start();
        try {
            latch.await();
//            System.out.println("finished" + idx);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Somthing {
    private int x = 0;
    private int y = 0;

    public synchronized void write() {
        x = 100;
        y = 50;
    }

    public synchronized void read() {
        if (x < y) {
            System.out.println("x < y");
        }
    }
}
