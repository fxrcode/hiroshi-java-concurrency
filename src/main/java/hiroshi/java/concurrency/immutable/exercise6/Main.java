package hiroshi.java.concurrency.immutable.exercise6;

public class Main {
    public static void main(String[] args) {
        MutablePerson mutable = new MutablePerson("start", "start");
        new CrackerThread(mutable).start();
        new CrackerThread(mutable).start();
        new CrackerThread(mutable).start();
        for (int i = 0; true; i++) {
            mutable.setPerson(String.valueOf(i), String.valueOf(i));
        }
    }
}

class CrackerThread extends Thread {
    private final MutablePerson mutablePerson;
    public CrackerThread(MutablePerson mutablePerson) {
        this.mutablePerson = mutablePerson;
    }

    @Override
    public void run() {
        while (true) {
            ImmutablePerson immutablePerson =  new ImmutablePerson(mutablePerson);
            if (!immutablePerson.getName().equals(immutablePerson.getAddress())) {
                System.out.println(currentThread().getName() + "********BROKEN********" + immutablePerson);
            }
        }
    }
}