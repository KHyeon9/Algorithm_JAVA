public class LeetCode3992 {
    // Count Prefix and Suffix Pairs I
    public String rearrangeString(String s, char x, char y) {
        StringBuilder sb = new StringBuilder();
        int xCnt = 0;
        for (char c : s.toCharArray()) {
            if (c != x && c != y) {
                sb.append(c);
            } else {
                if (c == y) {
                    sb.insert(0, y);
                } else {
                    xCnt++;
                }
            }
        }
        sb.repeat(x, xCnt);
        return sb.toString();
    }
}

