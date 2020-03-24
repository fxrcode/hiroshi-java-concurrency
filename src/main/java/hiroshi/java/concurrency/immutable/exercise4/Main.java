package hiroshi.java.concurrency.immutable.exercise4;

public class Main {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("Alice", "Alaska");
        System.out.println("userInfo = " + userInfo);
        StringBuffer info = userInfo.getInfo();
        info.replace(12, 17, "Bobby");
        System.out.println("userInfo = " + userInfo);
    }
}

class UserInfo {
    private final StringBuffer info;

    public UserInfo(String name, String address) {
        this.info = new StringBuffer("<name=\"" + name + "\" address=\"" + address + "\">");
    }

    public StringBuffer getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "UserInfo [info=" + info + "]";
    }

}