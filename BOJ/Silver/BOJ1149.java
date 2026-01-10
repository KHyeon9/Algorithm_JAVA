import java.io.*;
import java.util.*;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // rgb 비용 받기
        int[][] rgbVals = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgbVals[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dp 초기화
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i < 3; i++) {
            dp[1][i] = rgbVals[1][i];
        }
        // dp 계산
        for (int i = 2; i <= n; i++) {
            dp[i][0] = rgbVals[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = rgbVals[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = rgbVals[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        // 최소값 구하기
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer, dp[n][i]);
        }
        System.out.println(answer);
    }
}
