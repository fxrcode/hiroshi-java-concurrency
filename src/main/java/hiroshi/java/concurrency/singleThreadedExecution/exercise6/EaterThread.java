package hiroshi.java.concurrency.singleThreadedExecution.exercise6;

public class EaterThread extends Thread {
    private String name;
    private final Tool lefthand;
    private final Tool righthand;

    public EaterThread(String name, Tool lefthand, Tool righthand) {
        this.name = name;
        this.lefthand = lefthand;
        this.righthand = righthand;
    }

    @Override
    public void run() {
        while (true) {
            eat();
        }
    }

    public void eat() {
        synchronized (lefthand) {
            System.out.println(name + " takes up " + lefthand + " (left).");
            synchronized (righthand) {
                System.out.println(name + " takes up " + righthand + " (right).");
                System.out.println(name + " is eating now, yummy!");
                System.out.println(name + " puts down " + righthand + " (right).");
            }
            System.out.println(name + " puts down " + lefthand + " (left).");
        }
    }
}
