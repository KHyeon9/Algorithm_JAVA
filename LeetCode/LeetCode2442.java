import java.util.HashSet;
import java.util.Set;

public class LeetCode2442 {
    // Count Number of Distinct Integers After Reverse Operations
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        for (int num : nums) {
            int revNum = reverseNumber(num);
            set.add(revNum);
        }
        return set.size();
    }

    private int reverseNumber(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num).reverse();
        return Integer.parseInt(sb.toString());
    }
}

