import java.io.*;
import java.util.*;

public class BOJ11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] miro = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            miro[i] = Integer.parseInt(st.nextToken());
        }
        // dp 셋팅
        int[] dp = new int[n];
        // 최소값을 구하기 위해 max value로 셋팅
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 시작점 초기화
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int jump = miro[i];
            // 가지못하는 위치 처리
            if (dp[i] == Integer.MAX_VALUE) continue;
            // 이동
            for (int j = 1; j <= jump; j++) {
                // 이동거리가 목적지를 넘지 않는 경우
                if (i + j < n) {
                    dp[i + j] = Math.min(dp[i] +  1, dp[i + j]);
                }
            }
        }
        System.out.println(dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1]);
        br.close();
    }
}