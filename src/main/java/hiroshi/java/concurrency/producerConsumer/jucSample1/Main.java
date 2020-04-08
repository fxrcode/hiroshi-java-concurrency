package hiroshi.java.concurrency.producerConsumer.jucSample1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Table table = new Table(3);
        new Thread(new MakerThread("Maker-1", table, 31415)).start();
        new Thread(new MakerThread("Maker-2", table, 92653)).start();
        new Thread(new MakerThread("Maker-3", table, 58979)).start();
        Thread.sleep(100);
        new Thread(new EaterThread("Eater-1", table, 32384)).start();
        new Thread(new EaterThread("Eater-2", table, 62643)).start();
        new Thread(new EaterThread("Eater-3", table, 38327)).start();
    }
}
