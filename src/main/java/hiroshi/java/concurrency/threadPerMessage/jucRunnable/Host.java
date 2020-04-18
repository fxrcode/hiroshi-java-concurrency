package hiroshi.java.concurrency.threadPerMessage.jucRunnable;

import java.util.concurrent.Executor;

public class Host {
    private final Helper helper = new Helper();
    private final Executor executor;

    public Host(Executor executor) {
        this.executor = executor;
    }

    public void request(final int count, final char c) {
        System.out.println("\trequest(" + count + ", " + c + ") BEGIN");
//        new Thread(() -> helper.handle(count, c)).start();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                helper.handle(count, c);
            }
        });
        System.out.println("\trequest(" + count + ", " + c + ") END");
    }
}
