public class LeetCode3895 {
    // Count Digit Appearances
    public int countDigitOccurrences(int[] nums, int digit) {
        int ans = 0;
        for (int num : nums) {
            for (char c : String.valueOf(num).toCharArray()) {
                if (c - '0' == digit) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

