package hiroshi.java.concurrency.javaMemoryModel.b4;

public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();

        runner.start();

        runner.shutdown();
    }
}

class Runner extends Thread {
    private volatile boolean quit = false;

    @Override
    public void run() {
        while (!quit) {
            //
        }
        System.out.println("Done");
    }

    public void shutdown() {
        quit = true;
    }
}
