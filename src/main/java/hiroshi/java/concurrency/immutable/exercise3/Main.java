package hiroshi.java.concurrency.immutable.exercise3;

public class Main {
    private static final long CALL_COUNT = 1000_000_000L;

    public static void main(String[] args) {
        trial("NotSync", CALL_COUNT, new NotSync());
        trial("NotSync", CALL_COUNT, new Sync());
    }

    private static void trial(String msg, long count, Object obj) {
        System.out.println(msg + ": BEGIN");
        long start_time = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            obj.toString();
        }
        System.out.println(msg + ": END");
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start_time) + "ms.");
    }
}

class NotSync {
    private final String name = "NotSync";

    @Override
    public String toString() {
        return "NotSync{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Sync {
    private final String name = "Sync";

    @Override
    public String toString() {
        return "Sync{" +
                "name='" + name + '\'' +
                '}';
    }
}