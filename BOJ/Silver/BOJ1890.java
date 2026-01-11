import java.io.*;
import java.util.*;

public class BOJ1890 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int row = 0; row < n; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        // dp 셋팅
        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // 목적지 도차하면 그냥 탈출
                if (row == n - 1 && col == n - 1) {
                    break;
                }
                // 해당 위치가 갈 수 있는 위치인지
                if (dp[row][col] > 0) {
                    int moveVal = map[row][col];
                    // 다음 위치 범위 확인후 갈 수 있는 경로 갯수 추가
                    if (row + moveVal < n) {
                        dp[row + moveVal][col] += dp[row][col];
                    }
                    if (col + moveVal < n) {
                        dp[row][col + moveVal] += dp[row][col];
                    }
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}
