package hiroshi.java.concurrency.balking.sample;

public class Main {
    public static void main(String[] args) {

        Data data = new Data("src/main/resources/static/data.txt", "(empty)");
        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }
}
