import java.util.HashMap;
import java.util.Map;

public class LeetCode2053 {
    // Kth Distinct String in an Array
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int idx = 0;
        for (String s : arr) {
             if (map.get(s) == 1) {
                 idx++;
                 if (idx == k) return s;
             }
        }
        return "";
    }
}

