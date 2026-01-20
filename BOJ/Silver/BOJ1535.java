import java.io.*;
import java.util.*;

public class BOJ1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        // 감소 체력 셋팅
        int[] hp = new int[cnt + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= cnt; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }
        // 기쁨 셋팅
        int[] happy = new int[cnt + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= cnt; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }
        // dp 셋팅 (냅색 알고리즘)
        int[][] dp = new int[cnt + 1][100];
        for (int i = 1; i <= cnt; i++) {
            int disHp = hp[i];
            int incHappy = happy[i];
            for (int j = 1; j < 100 ; j++) {
                // hp가 0이면 안되므로 100 미만인 경우
                if (j >= disHp) {
                    // 이전 값에 현재 기쁨 증가 더해서 최대값 비교
                    int temp = dp[i - 1][j - disHp] + incHappy;
                    dp[i][j] = Math.max(dp[i - 1][j], temp);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[cnt][99]);
    }
}
