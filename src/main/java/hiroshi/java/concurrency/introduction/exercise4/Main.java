package hiroshi.java.concurrency.introduction.exercise4;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(1000, "A bad bank");
        new ClientThread(bank).start();
        new ClientThread(bank).start();
    }
}
