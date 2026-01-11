import java.io.*;
import java.util.*;

public class BOJ15990 {
    // dp 셋팅
    static long[][] dp = new long[100001][3];
    static long MOD = 1000000009;
    static {
        dp[1][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        // dp의 상태를 끝나는 수 1 2 3으로 나눠서 계산
        for (int row = 4; row < 100001; row++) {
            // 해당 끝나는 숫자에 따라 -1, -2, -3 위치의
            // 같은 숫자가 아닌값 더함
            dp[row][0] = (dp[row - 1][1] + dp[row - 1][2]) % MOD;
            dp[row][1] = (dp[row - 2][0] + dp[row - 2][2]) % MOD;
            dp[row][2] = (dp[row - 3][0] + dp[row - 3][1]) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());

            long answer = 0;
            for (int col = 0; col < 3; col++) {
                answer = (answer + dp[n][col]) % MOD;
            }
            System.out.println(answer);
        }
    }
}
