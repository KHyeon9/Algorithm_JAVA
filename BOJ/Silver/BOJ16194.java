import java.io.*;
import java.util.*;

public class BOJ16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 카드 코스트 셋팅
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cardCosts = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cardCosts[i] = Integer.parseInt(st.nextToken());
        }
        // dp
        int[] dp = new int[n + 1];
        // 최소값이므로 max값으로 채우기
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + cardCosts[j]);
            }
        }
        System.out.println(dp[n]);

    }
}
