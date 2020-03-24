package hiroshi.java.concurrency.balking.sample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Data {
    private final String fileName;
    private String content;
    private boolean changed;

    public Data(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    /**
     * guardedMethod
     *
     * @throws IOException
     */
    public synchronized void save() throws IOException {
        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    /**
     * stateChangingMethod
     *
     * @param newContent
     */
    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " called doSave, content = " + content);
        Writer writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
    }
}
