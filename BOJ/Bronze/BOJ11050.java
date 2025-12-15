import java.util.Scanner;

public class BOJ11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[n + 1][n + 1];
        // dp 배열 초기화
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
            dp[i][i] = 1;
        }
        // 점화식에 따라 dp에 입력
        // ex) 5C3 = 4C3 + 4C2
        // 위와 같이 점화식을 사용해 dp에 입력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        System.out.println(dp[n][k]);
    }
}
