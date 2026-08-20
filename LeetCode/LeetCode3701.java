public class LeetCode3701 {
    // Compute Alternating Sum
    public int alternatingSum(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += i % 2 == 0 ? nums[i] : -nums[i];
        }
        return ans;
    }
}
