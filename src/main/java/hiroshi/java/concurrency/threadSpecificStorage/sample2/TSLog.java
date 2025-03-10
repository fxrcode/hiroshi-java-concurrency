package hiroshi.java.concurrency.threadSpecificStorage.sample2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TSLog: ThreadSpecificLog
 */
public class TSLog {
    private PrintWriter writer = null;

    public TSLog(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String s) {
        writer.println(s);
    }

    public void close() {
        writer.println("=== END of Log===");
        writer.close();
    }
}
