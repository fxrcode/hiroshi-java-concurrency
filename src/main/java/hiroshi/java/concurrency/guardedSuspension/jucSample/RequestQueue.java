package hiroshi.java.concurrency.guardedSuspension.jucSample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

// GuardedObject
public class RequestQueue {
    // state
    private final BlockingDeque<Request> queue = new LinkedBlockingDeque<>();

    /**
     * guardedMethod: use while loop on condition and wait
     *
     * @return
     */
    public Request getRequest() {
        // while loop on NOT(guarded condition)
        Request req = null;
        try {
            req = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return req;
    }

    /**
     * stateChangingMethod: use notify/notifyAll
     *
     * @param request
     */
    public void putRequest(Request request) {
        try {
            queue.put(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
