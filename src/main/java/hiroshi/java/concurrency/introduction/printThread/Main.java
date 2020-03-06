package hiroshi.java.concurrency.introduction.printThread;

/**
 * I1-5: start thread class by extending Thread class
 */
public class Main {
    public static void main(String[] args) {
        new PrintThread("Good!").start();
        new PrintThread("Nice!").start();
        for (int i = 0; i < 1000; i++) {
            System.out.print("hh!");
        }
    }
}
