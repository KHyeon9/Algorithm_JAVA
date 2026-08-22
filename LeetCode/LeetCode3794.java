public class LeetCode3794 {
    // Reverse String Prefix
    public String reversePrefix(String s, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(s, 0, k).reverse().append(s.substring(k));
        return sb.toString();
    }
}
