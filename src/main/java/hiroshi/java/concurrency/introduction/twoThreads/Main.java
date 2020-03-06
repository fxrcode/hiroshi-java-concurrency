package hiroshi.java.concurrency.introduction.twoThreads;

/**
 * I1-4: start new thread, along with main thread
 */
public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        // thread's start will create a new thread, and then execute run().
        t.start();
        for (int i = 0; i < 1000; ++i) {
            System.out.print("Good!");
        }
    }
}
