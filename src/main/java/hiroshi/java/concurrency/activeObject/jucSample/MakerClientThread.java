package hiroshi.java.concurrency.activeObject.jucSample;

import hiroshi.java.concurrency.activeObject.jucSample.activeOjbect.ActiveObject;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

public class MakerClientThread extends Thread {
    private final ActiveObject activeObject;
    private final char fillchar;

    public MakerClientThread(String name, ActiveObject activeOjbect) {
        super(name);
        this.activeObject = activeOjbect;
        this.fillchar = name.charAt(0);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                Future<String> future = activeObject.makeString(i, fillchar);
                Thread.sleep(10);
                String value = future.get();
                System.out.println(Thread.currentThread().getName() + ": Value = " + value);
            }
        } catch (RejectedExecutionException | CancellationException | ExecutionException | InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ":" + e);
        }
    }
}
