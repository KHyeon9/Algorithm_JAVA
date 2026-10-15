public class LeetCode1844 {
    // Replace All Digits with Characters
    public String replaceDigits(String s) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                char prev = s.charAt(i - 1);
                char curr = (char) (prev + (c - '0'));
                ans.append(curr);
            }  else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}

