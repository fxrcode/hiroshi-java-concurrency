package hiroshi.java.concurrency.activeObject.sample.activeObject;

public class Servant implements ActiveObject {
    @Override
    public Result<String> makeString(int count, char fillchar) {
        char[] buff = new char[count];
        for (int i = 0; i < count; i++) {
            buff[i] = fillchar;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        return new RealResult<>(new String(buff));
    }

    @Override
    public void displayString(String string) {
        try {
            System.out.println("displayString: " + string);
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
