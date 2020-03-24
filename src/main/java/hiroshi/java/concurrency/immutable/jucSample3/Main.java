package hiroshi.java.concurrency.immutable.jucSample3;

import hiroshi.java.concurrency.immutable.jucSample1.ReaderThread;
import hiroshi.java.concurrency.immutable.jucSample1.WriterThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    public static void main(String[] args) {
        final List<Integer> list = new CopyOnWriteArrayList<Integer>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }

}