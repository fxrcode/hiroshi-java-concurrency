package hiroshi.java.concurrency.immutable.exercise6;

public class MutablePerson {
    private String name;
    private String address;

    public MutablePerson(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public MutablePerson(ImmutablePerson person) {
        this.name = person.getName();
        this.address = person.getAddress();
    }

    public synchronized void setPerson(String newName, String newAddress) {
        this.name = newName;
        this.address = newAddress;
    }

    public synchronized ImmutablePerson getImmutablePerson() {
        return new ImmutablePerson(this);
    }

    // default scope if package level. It's for immutablePerson to use it.
    String getName() {
        return name;
    }

    String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "MutablePerson{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
