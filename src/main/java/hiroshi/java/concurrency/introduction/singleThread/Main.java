package hiroshi.java.concurrency.introduction.singleThread;

/**
 * I1-3 : single thread: main thread
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i< 1000; ++i) {
            System.out.print("Good!");
        }
    }
}
