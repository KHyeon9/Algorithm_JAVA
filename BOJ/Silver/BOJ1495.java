import java.io.*;
import java.util.*;

public class BOJ1495 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int songCnt = Integer.parseInt(st.nextToken());
        int startVol = Integer.parseInt(st.nextToken());
        int maxVol = Integer.parseInt(st.nextToken());
        // 볼륨 리스트 저장
        st = new StringTokenizer(br.readLine());
        int[] volList = new int[songCnt + 1];
        for (int i = 1; i <= songCnt; i++) {
            volList[i] = Integer.parseInt(st.nextToken());
        }
        // dp 계산
        boolean[][] dp = new boolean[songCnt + 1][maxVol + 1];
        dp[0][startVol] = true;
        for (int i = 1; i <= songCnt; i++) {
            int nowVol = volList[i];
            for (int beforeVol = 0; beforeVol <= maxVol; beforeVol++) {
                // 이전 볼륨값이 존재하면
                if (dp[i - 1][beforeVol]) {
                    // 더한 값이 maxVol 이하인 경우
                    if (beforeVol + nowVol <= maxVol) {
                        dp[i][beforeVol + nowVol] = true;
                    }
                    // 뺀 값이 0이상인 경우
                    if (beforeVol - nowVol >= 0) {
                        dp[i][beforeVol - nowVol] = true;
                    }
                }
            }
        }
        // 최대값 구하기
        int answer = -1;
        for (int i = maxVol; i >= 0; i--) {
            if (dp[songCnt][i] == true) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
