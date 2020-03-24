package hiroshi.java.concurrency.immutable.jucSample2;

import hiroshi.java.concurrency.immutable.jucSample1.ReaderThread;
import hiroshi.java.concurrency.immutable.jucSample1.WriterThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Integer> list;
        list = Collections.synchronizedList(new ArrayList<Integer>());
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
