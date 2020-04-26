package hiroshi.java.concurrency.activeObject.jucSample.activeOjbect;

import java.util.concurrent.Future;

public interface ActiveObject {
    Future<String> makeString(int count, char fillchar);

    void displayString(String string);

    void shutdown();
}
