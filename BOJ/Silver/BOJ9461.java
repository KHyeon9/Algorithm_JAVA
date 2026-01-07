import java.util.*;

public class BOJ9461 {
    static long[] dp = new long[101];
    static {
        for (int i = 1; i < 3; i++) {
            dp[i] = 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int t = 0; t < testCase; t++) {
            int n = sc.nextInt();
            if (dp[n] == 0) {
                for (int i = 3; i <= n ; i++) {
                    dp[i] = dp[i - 3] + dp[i - 2];
                }
            }
            System.out.println(dp[n]);
        }
    }
}
