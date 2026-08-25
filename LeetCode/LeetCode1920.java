public class LeetCode1920 {
    // Build Array from Permutation
    public int[] buildArray(int[] nums) {
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[nums[i]];
        }
        return answer;
    }
}

