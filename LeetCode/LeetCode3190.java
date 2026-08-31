public class LeetCode3190 {
    // Find Minimum Operations to Make All Elements Divisible by Three
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans += Math.min(num % 3, Math.abs(3 - num));
        }
        return ans;
    }
}

