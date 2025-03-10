package hiroshi.java.concurrency.WorkerThread.Sample;

public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWorkers();
        new ClientThread("Alice", channel).start();
        new ClientThread("Bobby", channel).start();
        new ClientThread("Chang", channel).start();
    }
}
