package hiroshi.java.concurrency.threadPerMessage.sample;

public class Host {
    private final Helper helper = new Helper();

    public void request(final int count, final char c) {
        System.out.println("\trequest(" + count + ", " + c + ") BEGIN");
        new Thread(() -> helper.handle(count, c)).start();
        System.out.println("\trequest(" + count + ", " + c + ") END");
    }
}
