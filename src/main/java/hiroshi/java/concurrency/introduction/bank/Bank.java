package hiroshi.java.concurrency.introduction.bank;

public class Bank {
    private int money;
    private String name;

    public Bank(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public synchronized void deposit(int m) {
        money += m;
    }

    public synchronized boolean withdraw(int m) {
        if (money >=m ) {
            money -= m;
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }
}
