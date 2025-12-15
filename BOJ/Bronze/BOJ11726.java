import java.util.Scanner;

public class BOJ11726 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // dp 테이블 초기화
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
        }
        dp[0] = 1;
        dp[1] = 1;
        // 타일링 dp 로직 시작
        tiling(n);

        System.out.println(dp[n]);
    }

    private static int tiling(int n) {
        if (dp[n] != -1) return dp[n];
        return dp[n] = (tiling(n - 1) + tiling(n - 2)) % 10007;
    }
}
