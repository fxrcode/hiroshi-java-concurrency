package hiroshi.java.concurrency.threadSpecificStorage.sample2;

public class Log {
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();

    // write log
    public static void println(String s) {
        getTSLog().println(s);
    }

    // close log
    public static void close() {
        getTSLog().close();
    }

    // retrieve ThreadLocal log
    private static TSLog getTSLog() {
        TSLog tsLog = tsLogCollection.get();

        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }
        return tsLog;
    }
}
