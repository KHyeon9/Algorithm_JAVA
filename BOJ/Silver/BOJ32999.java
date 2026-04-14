import java.io.*;
import java.util.*;

public class BOJ32999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        // 리본 색 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ribbon = new int[cnt];
        int total = 0;
        for (int i = 0; i < cnt; i++) {
            ribbon[i] = Integer.parseInt(st.nextToken());
            total += ribbon[i];
        }
        // 계산
        int answer = 0;
        while (total > 0) {
            // 색을 칠할 범위
            int start = -1, end = cnt;
            for (int i = 0; i < cnt; i++) {
                // 시작점이 설정되지 않고 색을 칠해야 하는 경우
                if (start == -1 && ribbon[i] > 0) {
                    start = i;
                }
                // 시작점이 있고 색칠하면 안되는 부분을 구한 경우
                if (start != -1 && ribbon[i] == 0) {
                    end = i;
                    break;
                }
            }
            // 가장 적은 값의 색 구하기
            int minColor = Integer.MAX_VALUE;
            for (int i = start; i < end; i++) {
                minColor = Math.min(minColor, ribbon[i]);
            }
            // 색칠하여 값 값만큼 빼주기
            for (int i = start; i < end; i++) {
                ribbon[i] -= minColor;
                total -= minColor;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
