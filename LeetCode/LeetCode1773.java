import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1773 {
    // Count Items Matching a Rule
    static Map<String, Integer> idxMap = new HashMap<>();
    static {
        idxMap.put("type", 0);
        idxMap.put("color", 1);
        idxMap.put("name", 2);
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int idx = idxMap.get(ruleKey);
        int count = 0;

        for (List<String> item : items) {
            if (item.get(idx).equals(ruleValue)) count++;
        }
        return count;
    }
}

