public class LeetCode3019 {
    // Number of Changing Keys
    public int countKeyChanges(String s) {
        s = s.toLowerCase();
        int cnt = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}

