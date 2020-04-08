package hiroshi.java.concurrency.producerConsumer.jucSample1;

import java.util.Random;

public class EaterThread implements Runnable {
    private final Random random;
    private final Table table;
    public EaterThread(String name, Table table, long seed) {
        Thread.currentThread().setName(name);
        this.table = table;
        this.random = new Random(seed);
    }
    @Override
    public void run() {
        try {
            while (true) {
//                System.out.println("There're Total " + table.size() + " cakes");
                String cake = table.take();
                Thread.sleep(random.nextInt(1000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
