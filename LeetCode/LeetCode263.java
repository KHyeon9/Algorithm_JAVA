import java.util.*;

public class LeetCode263 {
    static int[] divNums = {2, 3, 5};

    // Ugly Number
    public boolean isUgly(int n) {
        // 0이하면 못생긴 숫자 아님
        if (n <= 0) return false;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(n);
        while (!dq.isEmpty()) {
            int now = dq.pollFirst();
            // 못생긴 숫자 확인
            if (now == 0) return true;
            // 소인수 3개 확인
            for (int num : divNums) {
                if (now % num == 0) {
                    dq.addLast(now / num);
                }
            }
        }
        return false;
    }
}
