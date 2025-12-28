import java.util.Scanner;

public class BOJ24416 {
    static int cnt1 = 0, cnt2 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        fibo1(n);
        fibo2(n);

        System.out.println(cnt1 + " " + cnt2);
    }

    private static int fibo1 (int n) {
        if (n < 3) {
            cnt1++;
            return 1;
        }
        return fibo1(n - 1) + fibo1(n -2);
    }

    private static int fibo2 (int n) {
        int[] dp = new int[(int) (n + 1)];
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            cnt2++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
