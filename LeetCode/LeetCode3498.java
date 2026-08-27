import java.util.HashMap;
import java.util.Map;

public class LeetCode3498 {
    // Reverse Degree of a String
    static Map<Character, Integer> reverseAlpa = new HashMap<>();
    static {
        for (int i = 0; i < 26; i++) {
            reverseAlpa.put((char)(i + 'a'), 26 - i);
        }
    }
    public int reverseDegree(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += reverseAlpa.get(s.charAt(i)) * (i + 1);
        }
        return ans;
    }
}

