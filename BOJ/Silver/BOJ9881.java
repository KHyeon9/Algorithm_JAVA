import java.io.*;
import java.util.*;

public class BOJ9881 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        int[] heights = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        // 정렬
        Arrays.sort(heights);
        // 최소값 계산
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 84; i++) {
            int nowMax = i + 17;
            int nowMin = i;
            int nowTotalCost = 0;
            for (int j = 0; j < cnt; j++) {
                // 범위에 따른 비용 추가
                if (heights[j] < nowMin) {
                    int diff = nowMin - heights[j];
                    nowTotalCost += diff * diff;
                } else if (heights[j] > nowMax) {
                    int diff = heights[j] - nowMax;
                    nowTotalCost += diff * diff;
                }
            }
            answer = Math.min(answer, nowTotalCost);
        }
        System.out.println(answer);
        br.close();
    }
}
