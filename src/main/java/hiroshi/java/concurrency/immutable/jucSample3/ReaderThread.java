package hiroshi.java.concurrency.immutable.jucSample3;

import java.util.List;

public class ReaderThread extends Thread {
    private final List<Integer> list;

    public ReaderThread(List<Integer> list) {
        super("ReaderThread");
        this.list = list;
    }

    /**
     * No need to synchronized since implicit iterator is also thread-safe with
     * Copy-on-write implementation.
     */
    @Override
    public void run() {
        while (true) {
            for (int n : list) {
                System.out.println(n);
            }
        }
    }
}