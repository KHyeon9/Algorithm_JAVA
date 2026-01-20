import java.util.Scanner;

public class BOJ1309 {
    static int[] dp = new int[100001];
    static {
        dp[1] = 3;
        dp[2] = 7;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1] * 2) % 9901;
        }
        System.out.println(dp[n]);
    }
}
