import java.io.*;
import java.util.*;

public class BOJ19947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] dp = new int[y + 1][3];
        dp[0][0] = h;
        for (int i = 1; i <= y; i++) {
            dp[i][0] = (int) (Math.max(
                    dp[i - 1][0],
                    Math.max(dp[i - 1][1], dp[i - 1][2])
            ) * 1.05);
            if (i > 2) {
                dp[i][1] = (int) (Math.max(
                        dp[i - 3][0],
                        Math.max(dp[i - 3][1], dp[i - 3][2])
                ) * 1.2);
            }
            if (i > 4) {
                dp[i][2] = (int) (Math.max(
                        dp[i - 5][0],
                        Math.max(dp[i - 5][1], dp[i - 5][2])
                ) * 1.35);
            }
        }
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer = Math.max(answer, dp[y][i]);
        }
        System.out.println(answer);
    }
}
