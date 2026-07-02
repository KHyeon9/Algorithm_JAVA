public class LeetCode1108 {
    // Defanging an IP Address
    public String defangIPaddr(String address) {
        // "."을 "[.]로 변경
        return address.replace(".", "[.]");
    }
}
