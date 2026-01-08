import java.util.Arrays;
import java.util.Scanner;

public class BOJ11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

            int[][] dp = new int[n + 1][10];
            for (int i = 0; i < 10 ; i++) {
                dp[1][i] = 1;
            }

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < 10; j++) {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j];
                        continue;
                    }
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
                }
            }

            long answer = 0;
            for (int i = 0; i < 10; i++) {
                answer += dp[n][i];
            }
            System.out.println(answer % 10007);

    }
}
