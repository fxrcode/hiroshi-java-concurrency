package hiroshi.java.concurrency.immutable.jucSample1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
/*
    private static class WriterThread extends Thread {
        private final List<Integer> list;
        public WriterThread(List<Integer> list) {
            super("WriterThread");
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; true; i++) {
                list.add(i);
                list.remove(0);
            }
        }
    }

    private static class ReaderThread extends Thread {
        private final List<Integer> list;
        public ReaderThread(List<Integer> list) {
            super("ReaderThread");
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                for (int i : list) {
                    System.out.println(i);
                }
            }
        }
    }*/
}
