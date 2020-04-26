package hiroshi.java.concurrency.activeObject.jucSample;

import hiroshi.java.concurrency.activeObject.jucSample.activeOjbect.ActiveObject;
import hiroshi.java.concurrency.activeObject.jucSample.activeOjbect.ActiveObjectFactory;

public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        try {
            new MakerClientThread("Alice", activeObject).start();
            new MakerClientThread("Bobby", activeObject).start();
            new DisplayClientThread("Christ", activeObject).start();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //
        } finally {
            System.out.println("*** shutdown ***");
            activeObject.shutdown();
        }
    }
}
