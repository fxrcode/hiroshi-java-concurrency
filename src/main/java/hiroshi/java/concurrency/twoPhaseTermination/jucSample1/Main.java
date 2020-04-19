package hiroshi.java.concurrency.twoPhaseTermination.jucSample1;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

public class Main {
    private static final int TASKS = 10;

    public static void main(String[] args) {
        runTasks(1);
        runTasks(3);
        runTasks(5);
        runTasks(10);
    }

    private static void runTasks(int workers) {
        System.out.println("BEGIN with workers COUNT: " + workers);
        final var executorService = Executors.newFixedThreadPool(workers);
        final var doneLatch = new CountDownLatch(TASKS);
        Instant start = Instant.now();
        try {
            // start to work
            for (int t = 0; t < TASKS; t++) {
                executorService.execute(new MyTask(doneLatch, t));
            }
            System.out.println("AWAIT");
            doneLatch.await();
        } catch (InterruptedException e) {
            //
        } finally {
            executorService.shutdown();
            long timeElapsed = Duration.between(start, Instant.now()).toMillis();
            System.out.println("END: " + timeElapsed);
        }
    }
}
