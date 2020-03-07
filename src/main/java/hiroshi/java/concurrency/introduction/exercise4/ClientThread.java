package hiroshi.java.concurrency.introduction.exercise4;

public class ClientThread extends Thread {
    private Bank bank;

    public ClientThread(Bank b) {
        this.bank = b;
    }

    @Override
    public void run() {
        while (true) try {
            Thread.sleep(100);
            boolean ok = bank.withdraw(1000);
            if (ok) {
                bank.deposit(1000);
            }
        } catch (InterruptedException ignored) {
        }
    }
}
