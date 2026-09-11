public class LeetCode1221 {
    // Split a String in Balanced Strings
    public int balancedStringSplit(String s) {
        int cnt = 0;
        int p = 0;

        for (char c : s.toCharArray()) {
            p += c == 'L' ? 1 : -1;
            if (p == 0) cnt++;
        }
        return cnt;
    }
}

