package hiroshi.java.concurrency.guardedSuspension.sample;

import java.util.LinkedList;
import java.util.Queue;

// GuardedObject
public class RequestQueue {
    // state
    private final Queue<Request> queue = new LinkedList<>();

    /**
     * guardedMethod: use while loop on condition and wait
     * @return
     */
    public synchronized Request getRequest() {
        // while loop on NOT(guarded condition)
        while (queue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }

    /**
     * stateChangingMethod: use notify/notifyAll
     * @param request
     */
    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}
