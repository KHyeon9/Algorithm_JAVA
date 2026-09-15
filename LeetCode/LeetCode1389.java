import java.util.ArrayList;
import java.util.List;

public class LeetCode1389 {
    // Create Target Array in the Given Order
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            ans.add(index[i], nums[i]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}

