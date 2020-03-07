package hiroshi.java.concurrency.singleThreadedExecution.sample1;

public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "NoWhere";

    public void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    @Override
    public String toString() {
        return "Gate{" +
                "counter=" + counter +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("*********** BORKEN *********" + toString());
        }
    }
}
