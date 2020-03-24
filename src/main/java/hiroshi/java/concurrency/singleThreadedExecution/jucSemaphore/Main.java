package hiroshi.java.concurrency.singleThreadedExecution.jucSemaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world.");
        BoundedResource resource = new BoundedResource(3);
        for (int i = 0; i < 10; i++) {
            new UserThread(resource).start();
        }
    }
}

class Log {
    public static void println(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}

class BoundedResource {
    private final Semaphore sema;
    private final int permits;
    private final static Random random = new Random(314159);

    public BoundedResource(int permits) throws InterruptedException {
        this.sema = new Semaphore(permits);
        this.permits = permits;
    }

    public void use() throws InterruptedException {
        sema.acquire();
        try {
            doUse();
        } finally {
            sema.release();
        }
    }

    protected void doUse() throws InterruptedException {
        Log.println("BEGIN: used = " + (permits - sema.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("END:   used = " + (permits - sema.availablePermits()));
    }
}

class UserThread extends Thread {
    private final static Random random = new Random(26535);
    private final BoundedResource resource;
    public UserThread(BoundedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                resource.use();
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {
            //
        }
    }
}
