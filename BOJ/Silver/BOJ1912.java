import java.io.*;
import java.util.*;

public class BOJ1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 배열 셋팅
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // dp
        int answer = Integer.MIN_VALUE;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            answer = Math.max(answer, dp[i]);
        }
        // 출력
        System.out.println(answer);
    }
}
