import java.util.ArrayList;
import java.util.List;

public class LeetCode728 {
    // Self Dividing Numbers
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            boolean flag = true;
            for (char c : String.valueOf(num).toCharArray()) {
                int div = c - '0';
                if (div == 0 || num % div != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans.add(num);
        }
        return ans;
    }
}

