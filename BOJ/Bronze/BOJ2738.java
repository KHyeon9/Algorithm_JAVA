import java.io.*;
import java.util.*;

public class BOJ2738 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 더해질 배열 셋팅
        int[][] arr = new int[n][m];
        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; col++) {
                arr[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력 받이서 더하기
        StringBuilder answer = new StringBuilder();
        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; col++) {
                int addNum = Integer.parseInt(st.nextToken());
                answer.append((arr[row][col] + addNum) + " ");
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }
}
