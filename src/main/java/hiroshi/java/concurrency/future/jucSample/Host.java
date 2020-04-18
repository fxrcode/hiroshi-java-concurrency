package hiroshi.java.concurrency.future.jucSample;

import java.util.concurrent.Callable;

public class Host {
    public FutureData request(final int count, final char c) {
        System.out.println("\trequest(" + count + ", " + c + ") BEGIN");
        // (1) create FutureData instance, pass Callable<RealData> into ctor
        FutureData future = new FutureData(
                new Callable<RealData>() {
                    @Override
                    public RealData call() throws Exception {
                        return new RealData(count, c);
                    }
                }
        );

        // (2) Spawn a new Thread to construct RealData instance
        new Thread(future).start();

        System.out.println("\trequest(" + count + ", " + c + ") END");

        // (3)  return FutureData instance
        return future;
    }
}
