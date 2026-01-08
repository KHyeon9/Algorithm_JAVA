import java.util.Scanner;

public class BOJ9095 {
    static int[] dp = new int[11];
    static {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for (int i = 5; i < 11; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n  = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
