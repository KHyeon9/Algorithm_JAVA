import java.io.*;
import java.util.*;

public class BOJ18353 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] combarPower = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            combarPower[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1];
        // LIS 알고리즘
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (combarPower[i] < combarPower[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        // 최대 길이 구하기
        int answer = 0;
        for (int len : dp) {
            answer = Math.max(len, answer);
        }
        System.out.println(n - answer);
    }
}