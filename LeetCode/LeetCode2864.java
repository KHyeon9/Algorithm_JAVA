public class LeetCode2864 {
    // Maximum Odd Binary Number
    public String maximumOddBinaryNumber(String s) {
        int oneCnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') oneCnt++;
        }

        oneCnt--;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            if (oneCnt > 0) {
                oneCnt--;
                result.append('1');
            }
            else result.append('0');
        }
        result.append('1');
        return result.toString();
    }
}

