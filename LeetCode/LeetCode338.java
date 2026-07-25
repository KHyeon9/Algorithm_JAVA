import java.util.*;

public class LeetCode338 {
    // Counting Bits
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // 2진법으로 변경후 1의 갯수 세기
            String bin = Integer.toBinaryString(i);
            for (char c : bin.toCharArray()) {
                res[i] += c - '0';
            }
        }
        return res;
    }
}
