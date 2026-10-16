import java.util.HashMap;
import java.util.Map;

public class LeetCode2325 {
    // Decode the Message
    public String decodeMessage(String key, String message) {
        Map<Character, Character> decode = new HashMap<>();
        char cur = 'a';
        for (char c : key.toCharArray()) {
            if (c != ' ' && !decode.containsKey(c)) {
                decode.put(c, cur);
                cur++;
            }
        }
        System.out.println(decode);
        StringBuilder ans = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (decode.containsKey(c)) {
                ans.append(decode.get(c));
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}

