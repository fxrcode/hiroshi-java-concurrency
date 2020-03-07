package hiroshi.java.concurrency.introduction.printerRunnable;

/**
 * I1-6: start thread class by extending Thread class
 */
public class Main {
    public static void main(String[] args) {
        new Thread(new Printer("Good!")).start();
        new Thread(new Printer("Nice!")).start();
        for (int i = 0; i < 1000; i++) {
            System.out.print("hh-");
        }
    }
}
