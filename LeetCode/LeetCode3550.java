public class LeetCode3550 {
    // Smallest Index With Digit Sum Equal to Index
    public int smallestIndex(int[] nums) {
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0, curNum = nums[i];
            while (curNum > 0) {
                sum += curNum % 10;
                curNum /= 10;
            }
            if (sum == i) {
                return i;
            }
        }
        return -1;
    }
}

