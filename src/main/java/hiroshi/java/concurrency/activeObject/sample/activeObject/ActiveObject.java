package hiroshi.java.concurrency.activeObject.sample.activeObject;

public interface ActiveObject {
    Result<String> makeString(int count, char fillchar);

    void displayString(String string);
}
