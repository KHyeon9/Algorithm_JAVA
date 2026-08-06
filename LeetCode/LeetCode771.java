import java.util.*;

public class LeetCode771 {
    // Jewels and Stones
    public int numJewelsInStones(String jewels, String stones) {
        // 갯수 저장
        Map<Character, Integer> map = new HashMap<>();
        for (char c : stones.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 계산
        int ans = 0;
        for (char c : jewels.toCharArray()) {
            if (map.containsKey(c)) {
                ans += map.get(c);
            }
        }
        return ans;
    }
}
