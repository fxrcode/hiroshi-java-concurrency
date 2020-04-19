package hiroshi.java.concurrency.twoPhaseTermination.jucSample2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Cool, I can now use CountdownLatch + CyclicLatch to build concurrent pipeline.
 * Used in OnboardingService!
 * + no need to do scanAndDispatch
 */
public class Main {
    private static final int WORKERS = 3;

    public static void main(String[] args) {
        doMain();
    }

    private static void doMain() {
        System.out.println("BEGIN");
        // Threadpool
        ExecutorService service = Executors.newFixedThreadPool(WORKERS);

        // callback onBarrierRemoved
        Runnable barrierAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("Barrier Action");
            }
        };

        // CyclicBarrier to sync ALL workers in "phase"
        CyclicBarrier phaseBarrier = new CyclicBarrier(WORKERS, barrierAction);

        // CountdownLatch to check if work is done
        CountDownLatch doneLatch = new CountDownLatch(WORKERS);

        try {
            for (int t = 0; t < WORKERS; t++) {
                service.execute(new MyTask(phaseBarrier, doneLatch, t));
            }
            // after all Tasks done
            System.out.println("AWAIT");
            doneLatch.await();
            System.out.println("doneLatch is 0");
        } catch (InterruptedException e) {
            //
        } finally {
            System.out.println("Comes into shutdown threadpool");
            service.shutdown();
            System.out.println("END");
        }
    }
}
