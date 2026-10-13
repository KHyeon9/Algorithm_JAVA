public class LeetCode2315 {
    // Count Asterisks
    public int countAsterisks(String s) {
        String[] strs = s.split("\\|");

        int cnt = 0;
        for (int i = 0; i < strs.length; i += 2) {
            for (char c : strs[i].toCharArray()) {
                if (c == '*') cnt++;
            }
        }
        return cnt;
    }
}

