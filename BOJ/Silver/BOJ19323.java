import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ19323 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int row = 2; row <= n; row++) {
            for (int col = 1; col <= row; col++){
                int nowSum;
                if (col == 1) {
                    nowSum = dp[row][col] + dp[row - 1][col];
                } else if (col == row) {
                    nowSum = dp[row][col] + dp[row - 1][col - 1];
                } else {
                    int maxBefore = Math.max(dp[row - 1][col - 1], dp[row - 1][col]);
                    nowSum = dp[row][col] + maxBefore;
                }
                dp[row][col] = nowSum;
            }
        }
        int answer = 0;
        for (int num : dp[n]) {
            answer = Math.max(answer, num);
        }
        System.out.println(answer);
    }
}
