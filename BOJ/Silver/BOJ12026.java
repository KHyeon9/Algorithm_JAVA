import java.io.*;
import java.util.Arrays;

public class BOJ12026 {
    // MAX_VALUE로 하면 값이 음수가 되어 문제 생길 수도 있음
    static int INF = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String road = br.readLine();
        // dp로직 시작
        int[] dp = new int[n];
        // 최소값이므로 INF로 채움
        Arrays.fill(dp, INF);
        // 시작점 셋팅
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            // 현재 알파벳
            char now = road.charAt(i);
            for (int j = 0; j < i; j++) {
                // INF보다 크면 넘어감
                if (dp[j] >= INF) continue;
                char before = road.charAt(j);
                // 이전 알파벳과 현재 알파벳이 맞는 순서인 경우
                if (isOk(now, before)) {
                    // 이전 알파벳에 가는 에너지 + 현재 알파벳까지 에너지
                    int val = dp[j] + (i - j) * (i - j);
                    // 최소값이면 값 변경
                    dp[i] = Math.min(dp[i], val);
                }
            }
        }
        System.out.println(dp[n - 1] >= INF ? -1 : dp[n - 1]);
    }

    private static boolean isOk(char now, char before) {
        if (now == 'B' && before == 'J') return true;
        if (now == 'O' && before == 'B') return true;
        if (now == 'J' && before == 'O') return true;
        return false;
    }
}
