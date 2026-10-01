import java.util.Arrays;

public class LeetCode3432 {
    // Count Partitions with Even Sum Difference
    public int countPartitions(int[] nums) {
        int leftSum = 0, rightSum = Arrays.stream(nums).sum();
        int ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            rightSum -= nums[i];
            leftSum += nums[i];

            if ((leftSum - rightSum) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}

