package hiroshi.java.concurrency.producerConsumer.jucSample2;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<char[]> exchanger = new Exchanger<>();
        char[] buf1 = new char[10];
        char[] buf2 = new char[10];
        new ProducerThread(exchanger, buf1, 314159).start();
        new ConsumerThread(exchanger, buf2, 265358).start();
    }
}
