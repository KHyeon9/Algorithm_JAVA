import java.io.*;

public class BOJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        
        int cnt = Integer.parseInt(br.readLine());
        // 배열 초기화
        int[] stairVal = new int[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            stairVal[i] = Integer.parseInt(br.readLine());
        }
        // dp
        int[][] dp = new int[cnt + 1][2];
        dp[1][0] = stairVal[1];
        // 예외 처리
        if (cnt >= 2) {
            // 1칸 넘은 경우
            dp[2][0] = stairVal[1] + stairVal[2];
            // 2칸 넘은 경우
            dp[2][1] = stairVal[2];
        }

        for (int i = 3; i <= cnt; i++) {
            // 연속해서 3번을 1칸 뛸수 없음으로
            // 3번째에서 2칸 올라온 뒤 이전 한칸의 값을 더해준 최대값
            dp[i][0] = Math.max(dp[i - 3][0], dp[i - 3][1]) + stairVal[i - 1] + stairVal[i];
            // 2칸 이동은 아무때나 상관없음으로 바로 비교
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairVal[i];
        }

        System.out.println(Math.max(dp[cnt][0], dp[cnt][1]));
    }
}
