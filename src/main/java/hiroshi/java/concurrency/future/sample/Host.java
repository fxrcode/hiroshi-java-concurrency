package hiroshi.java.concurrency.future.sample;

public class Host {
    public Data request(final int count, final char c) {
        System.out.println("\trequest(" + count + ", " + c + ") BEGIN");
        // (1) create FutureData instance
        final FutureData future = new FutureData();

        // (2) Spawn a new Thread to construct RealData instance
        new Thread() {
            @Override
            public void run() {
                RealData realData = new RealData(count, c);
                future.setRealData(realData);
            }
        }.start();
        System.out.println("\trequest(" + count + ", " + c + ") END");

        // (3) return FutureData instance
        return future;
    }
}
