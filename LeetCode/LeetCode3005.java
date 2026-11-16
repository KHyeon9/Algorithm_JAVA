import java.util.*;

public class LeetCode3005 {
    // Count Elements With Maximum Frequency
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxCnt = 0;
        for (int num : nums) {
            maxCnt = Math.max(maxCnt, map.get(num));
        }

        int ans = 0;
        for (int num : nums) {
            if (map.get(num) == maxCnt) ans++;
        }
        return ans;
    }
}

