import java.io.*;
import java.util.*;

public class BOJ2565 {
    static class LineInfo {
        int left, right;

        public LineInfo (int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        LineInfo[] lines = new LineInfo[cnt];
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            lines[i] = new LineInfo(left, right);
        }
        // 정렬
        Arrays.sort(lines, (o1, o2) -> {
            return o1.left - o2.left;
        });
        // dp
        int maxVal = 0;
        int[] dp = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 정렬된 전선의 오른쪽을 기준로 LIS 구하기
                if (lines[i].right > lines[j].right) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxVal = Math.max(maxVal, dp[i]);
        }
        System.out.println(cnt - maxVal);
    }
}
