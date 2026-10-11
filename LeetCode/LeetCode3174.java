public class LeetCode3174 {
    // Clear Digits
    public String clearDigits(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                for (int j = i - 1;j >= 0;j--) {
                    if (Character.isLetter(chars[j])) {
                        chars[i] = '-';
                        chars[j] = '-';
                        break;
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : chars) {
            if (c != '-') {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}

