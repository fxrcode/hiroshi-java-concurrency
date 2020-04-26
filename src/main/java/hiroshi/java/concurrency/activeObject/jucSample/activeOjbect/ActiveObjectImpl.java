package hiroshi.java.concurrency.activeObject.jucSample.activeOjbect;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ActiveObjectImpl implements ActiveObject {
    private final ExecutorService service = Executors.newSingleThreadExecutor();

    @Override
    public Future<String> makeString(int count, char fillchar) {
        class MakeStringRequest implements Callable<String> {
            @Override
            public String call() throws Exception {
                char[] buff = new char[count];
                for (int i = 0; i < count; i++) {
                    buff[i] = fillchar;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
                return new String(buff);
            }
        }
        return service.submit(new MakeStringRequest());
    }

    @Override
    public void displayString(String string) {
        class DisplayStringRequest implements Runnable {
            @Override
            public void run() {
                try {
                    System.out.println("displayString: " + string);
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
        service.execute(new DisplayStringRequest());
    }

    @Override
    public void shutdown() {
        service.shutdown();
    }
}
