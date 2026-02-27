import java.io.*;
import java.util.*;

public class BOJ17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br .readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] fuel = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                fuel[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[3][n][m];
        for (int c = 0; c < m; c++) {
            for (int z = 0; z < 3; z++) {
                dp[z][0][c] = fuel[0][c];
            }
        }
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < m; c++) {
                for (int z = 0; z < 3; z++) {
                    dp[z][r][c] = 1000000;
                }
            }
        }
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < m; c++) {
                // 왼쪽에서 오는 경우 범위 확인 및 계산
                if (c - 1 >= 0) {
                    int minBeforeLeft = Math.min(
                            dp[1][r - 1][c - 1], dp[2][r - 1][c - 1]
                    );
                    dp[0][r][c] = fuel[r][c] + minBeforeLeft;
                }
                // 중앙인 경우는 값이 다 존재하므로 계산
                int minBeforeMid = Math.min(
                        dp[0][r - 1][c], dp[2][r - 1][c]
                );
                dp[1][r][c] = fuel[r][c] + minBeforeMid;
                // 오른쪽에서 오는 경우 범위 확인 및 계산
                if (c + 1 < m) {
                    int minBeforeRight = Math.min(
                            dp[0][r - 1][c + 1], dp[1][r - 1][c + 1]
                    );
                    dp[2][r][c] = fuel[r][c] + minBeforeRight;
                }
            }
        }
        // 최소값 구하기
        int answer = Integer.MAX_VALUE;
        for (int c = 0; c < m; c++) {
            for (int z = 0; z < 3; z++) {
                answer = Math.min(answer, dp[z][n - 1][c]);
            }
        }
        System.out.println(answer);
        br.close();
    }
}
