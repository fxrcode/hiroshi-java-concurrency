package hiroshi.java.concurrency.introduction.printThread;

public class PrintThread extends Thread{
    private String message;
    public PrintThread(String msg) {
        this.message = msg;
    }

    @Override
    public void run() {
        System.out.println("\n" + Thread.currentThread().getId());
        for (int i = 0; i < 1000; ++i) {
            System.out.print(message);
        }
    }
}
