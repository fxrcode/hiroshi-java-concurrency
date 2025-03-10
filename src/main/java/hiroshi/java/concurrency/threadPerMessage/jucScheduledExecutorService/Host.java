package hiroshi.java.concurrency.threadPerMessage.jucScheduledExecutorService;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Host {
    private final Helper helper = new Helper();
    private final ScheduledExecutorService scheduledExecutorService;

    public Host(ScheduledExecutorService scheduledExectorService) {
        this.scheduledExecutorService = scheduledExectorService;
    }

    public void request(final int count, final char c) {
        System.out.println("\trequest(" + count + ", " + c + ") BEGIN");
        scheduledExecutorService.schedule(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count, c);
                    }
                },
                3L,
                TimeUnit.SECONDS);
        System.out.println("\trequest(" + count + ", " + c + ") END");
    }
}
