package hiroshi.java.concurrency.activeObject.sample.activeObject;

public class ActiveObjectFactory {
    public static ActiveObject createActiveOjbect() {
        Servant servant = new Servant();
        ActivationQueue queue = new ActivationQueue();
        SchedulerThread scheduelr = new SchedulerThread(queue);
        Proxy proxy = new Proxy(scheduelr, servant);
        scheduelr.start();
        return proxy;
    }
}
