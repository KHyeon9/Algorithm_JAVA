import java.util.HashMap;
import java.util.Map;

public class LeetCode136 {
    // Single Number
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numCnt = new HashMap<>();

        for (int num : nums) {
            numCnt.put(num, numCnt.getOrDefault(num, 0) + 1);
        }

        for (int num : numCnt.keySet()) {
            if (numCnt.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }
}
