public class LeetCode3110 {
    // Score of a String
    public int scoreOfString(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            ans += Math.abs(chars[i] - chars[i + 1]);
        }
        return ans;
    }
}
