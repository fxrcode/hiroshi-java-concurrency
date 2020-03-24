package hiroshi.java.concurrency.immutable.exercise2;

public class Main {
    public static void main(String[] args) {
        String s = "FLAG";
        String t = s.replace('A', 'C');
        System.out.println("s = " + s);
        System.out.println("t = " + t);
        System.out.println("s == t?" + (s == t));
    }
}
