import java.io.*;
import java.util.*;

public class BOJ2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] answer = solve(d, k);
        for (int cnt : answer) {
            System.out.println(cnt);
        }
    }

    private static int[] solve(int day, int riceCakeCnt) {
        int[] dp = new int[day + 1];

        for (int first = 1; first <= riceCakeCnt; first++) {
            for (int second = 2; second <= riceCakeCnt; second++) {
                dp[1] = first;
                dp[2] = second;

                for (int i = 3; i <= day; i++) {
                    dp[i] = dp[i - 1] + dp[i -2];
                }
                if (dp[day] == riceCakeCnt) {
                    return new int[] {first, second};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
