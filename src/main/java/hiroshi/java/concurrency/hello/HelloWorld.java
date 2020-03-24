package hiroshi.java.concurrency.hello;

public class HelloWorld {
    // 5 units in JVM memory
    private static String s = "HelloWorld";

    // frame unit is function: scope
    public int add() {
        int a = 1;
        int b = 2;
        int c = (a+b) * 100;
        return c;
    }

    /**
     * Bilibili bat.qq.com.jvmInternal
     * debug run and thread dump to see main is ran by a thread
     * use jps in terminal to see process
     * @param args
     */
    public static void main(String[] args) {
        HelloWorld app = new HelloWorld();
        int result = app.add();
        System.out.println(result);
    }
}
