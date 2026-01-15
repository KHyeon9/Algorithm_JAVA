import java.io.*;
import java.util.*;

public class BOJ2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        // 와인 배열 초기화
        int[] wineVal = new int[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            wineVal[i] = Integer.parseInt(br.readLine());
        }
        // DP
        int[][] dp = new int[cnt + 1][3];
        for (int i = 1; i <= cnt; i++) {
            // 안고르는 경우
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            // 연속하지 않고 내거 고르는 경우
            dp[i][1] = dp[i - 1][0] + wineVal[i];
            // 연속해서 2개 고르는 경우
            dp[i][2] = dp[i - 1][1] + wineVal[i];
        }

        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer = Math.max(answer, dp[cnt][i]);
        }
        System.out.println(answer);
    }
}
