import java.util.*;

public class LeetCode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 속도를 위한 map 선언
        Map<Integer, Integer> numAndIdx = new HashMap<>();
        // 계산
        for (int i = 0; i < nums.length; i++) {
            // 포함되어 있고 index의 차이가 k이하인 경우 true
            if (numAndIdx.containsKey(nums[i]) &&
                    Math.abs(i - numAndIdx.get(nums[i])) <= k) return true;
            numAndIdx.put(nums[i], i);
        }
        // 조건이 아니면 false
        return false;
    }
}
