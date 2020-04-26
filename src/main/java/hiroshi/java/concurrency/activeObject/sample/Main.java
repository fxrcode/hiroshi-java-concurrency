package hiroshi.java.concurrency.activeObject.sample;

import hiroshi.java.concurrency.activeObject.sample.activeObject.ActiveObject;
import hiroshi.java.concurrency.activeObject.sample.activeObject.ActiveObjectFactory;

public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveOjbect();
        new MakerClientThread("Alice", activeObject).start();
        new MakerClientThread("Bobby", activeObject).start();
        new DisplayClientThread("Chris", activeObject).start();
    }
}
