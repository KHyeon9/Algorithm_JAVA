public class LeetCode3168 {
    // Minimum Number of Chairs in a Waiting Room
    public int minimumChairs(String s) {
        int maxCnt = 0, nowCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'E') {
                nowCnt++;
                maxCnt = Math.max(maxCnt, nowCnt);
            } else {
                nowCnt--;
            }
        }
        return maxCnt;
    }
}

