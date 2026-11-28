import java.util.HashMap;
import java.util.Map;

public class LeetCode1394 {
    // Find Lucky Integer in an Array
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = -1;
        for (int num : map.keySet()) {
            if (num == map.get(num)) {
                res = Math.max(res, num);
            }
        }
        return res;
    }
}

