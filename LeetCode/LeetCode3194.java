import java.util.Arrays;

public class LeetCode3194 {
    // Minimum Average of Smallest and Largest Elements
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length / 2; i++) {
            double curr = ((double) nums[i] + nums[nums.length - 1 - i]) / 2;

            ans = Math.min(ans, curr);
        }

        return ans;
    }
}

