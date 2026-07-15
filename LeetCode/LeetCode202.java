import java.util.*;

public class LeetCode202 {
    // Happy Number
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            // 각 자리수 제곱의 합
            for (char c : String.valueOf(n).toCharArray()) {
                int num = c - '0';
                sum += num * num;
            }
            n = sum;
            // 나온 수면 탈출
            if (set.contains(n)) break;
            set.add(n);
        }
        return n == 1;
    }
}
