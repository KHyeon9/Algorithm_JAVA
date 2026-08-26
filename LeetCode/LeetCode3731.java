import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode3731 {
    // Find Missing Elements
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                for (int j = 1; j < nums[i] - nums[i - 1]; j++) {
                    list.add(nums[i - 1] + j);
                }
            }
        }
        return list;
    }
}

