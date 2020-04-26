package hiroshi.java.concurrency.activeObject.jucSample.activeOjbect;

public class ActiveObjectFactory {
    public static ActiveObject createActiveObject() {
        return new ActiveObjectImpl();
    }
}
