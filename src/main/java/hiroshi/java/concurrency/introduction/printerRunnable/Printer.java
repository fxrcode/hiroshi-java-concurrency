package hiroshi.java.concurrency.introduction.printerRunnable;

public class Printer implements Runnable {
    private String message;
    public Printer(String msg) {
        this.message = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.print(message);
        }
    }
}
