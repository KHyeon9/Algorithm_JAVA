import java.util.Arrays;

public class LeetCode3467 {
    // Transform Array by Parity
    public int[] transformArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                nums[i] = 1;
            } else  {
                nums[i] = 0;
            }
        }
        Arrays.sort(nums);
        return nums;
    }
}
