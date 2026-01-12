import java.io.*;
import java.util.*;

public class BOJ14494 {
    static long[][] dp = new long[1001][1001];
    static {
        for (int row = 1; row <= 1000; row++) dp[row][1] = 1;
        for (int col = 2; col <= 1000; col++) dp[1][col] = 1;

        for (int row = 2; row < 1001; row++) {
            for (int col = 2; col < 1001; col++) {
                dp[row][col] = (dp[row - 1][col] + dp[row][col - 1] + dp[row - 1][col - 1]) % 1000000007;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(dp[n][m]);
    }
}
