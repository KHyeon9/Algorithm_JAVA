import java.util.Arrays;

public class LeetCode3512 {
    // Minimum Operations to Make Array Sum Divisible by K
    public int minOperations(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        return sum % k;
    }
}
