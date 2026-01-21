import java.io.*;
import java.util.*;

public class BOJ2502 {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        solve(cnt, day);

        System.out.println(dp[1]);
        System.out.println(dp[2]);
    }

    private static void solve(int cnt, int day) {
        for (int i = 0; i < cnt; i++) {
            dp = new int[day + 1];
            for (int first = 1; first < cnt; first++) {
                for (int second = 1; second < cnt; second++) {
                    dp[1] = first;
                    dp[2] = second;
                    for (int j = 3; j <= day; j++) {
                        dp[j] = dp[j - 1] + dp[j - 2];
                    }

                    if (dp[day] == cnt) {
                        return;
                    }
                }
            }
        }
    }
}
