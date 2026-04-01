import java.io.*;

public class BOJ32437 {
    // 피보나치 저장 dp 셋팅
    static int[] dp = new int[41];
    static {
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < 41; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
        br.close();
    }
}
