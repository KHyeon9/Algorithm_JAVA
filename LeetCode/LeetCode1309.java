import java.util.HashMap;
import java.util.Map;

public class LeetCode1309 {
    // Decrypt String from Alphabet to Integer Mapping
    static Map<String, Character> map = new HashMap<>();
    static {
        for (int i = 0; i < 26; i++) {
            char curAlpa = (char) ('a' + i);
            if (i < 9) {
                map.put((i + 1) + "", curAlpa);
            } else {
                map.put((i + 1) + "#", curAlpa);
            }
        }
    }
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = s.length() - 1;
        while (idx >= 0) {
            if (s.charAt(idx) == '#') {
                String key = s.substring(idx - 2, idx + 1);
                sb.append(map.get(key));
                idx -= 3;
            } else {
                sb.append(map.get(String.valueOf(s.charAt(idx))));
                idx--;
            }
        }
        return sb.reverse().toString();
    }
}

