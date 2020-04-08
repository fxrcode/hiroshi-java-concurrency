package hiroshi.java.concurrency.producerConsumer.jucSample1;

import java.util.Random;

public class MakerThread implements Runnable {
    private Table table;
    private Random random;
    private String name;
    private static int id = 0;  //

    public MakerThread(String name, Table table, long seed) {
        this.name = name;
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[ Cake No." + nextId() + " by " + name + " ]";
                table.put(cake);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
