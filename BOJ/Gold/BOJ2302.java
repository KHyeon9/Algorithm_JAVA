import java.io.*;

public class BOJ2302 {
    static int[] dp = new int[41];
    static {
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int range = Integer.parseInt(br.readLine());

        int cnt = Integer.parseInt(br.readLine());
        int answer = 1;
        int before = 1;
        for (int i = 0; i < cnt; i++) {
            int vip = Integer.parseInt(br.readLine());
            int nowRange = vip - before;
            // vip 다음 위치 부터 시작해야 하므로 +1
            before = vip + 1;
            answer *= dp[nowRange];
        }
        // 마지막 끝값이므로 + 1로 처리하여 범위를 맞춰줌
        answer *= dp[range - before + 1];
        System.out.println(answer);
    }
}
