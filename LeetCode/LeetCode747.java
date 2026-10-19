public class LeetCode747 {
    // Largest Number At Least Twice of Others
    public int dominantIndex(int[] nums) {
        int max = 0, maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        for (int num : nums) {
            if (max != num && num * 2 > max) {
                return -1;
            }
        }
        return maxIdx;
    }
}

