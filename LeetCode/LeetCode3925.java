public class LeetCode3925 {
    // Concatenate Array With Reverse
    public int[] concatWithReverse(int[] nums) {
        int[] ans = new int[nums.length * 2];
        System.arraycopy(nums, 0, ans, 0, nums.length);
        for (int i = 0; i < nums.length; i--) {
            ans[i + nums.length] = nums[nums.length - i - 1];
        }
        return ans;
    }
}
