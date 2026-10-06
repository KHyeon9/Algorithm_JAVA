public class LeetCode2185 {
    // Counting Words With a Given Prefix
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;

        for (String word : words) {
            if (word.startsWith(pref)) {
                cnt++;
            }
        }
        return cnt;
    }
}

