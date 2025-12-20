import java.io.*;
import java.util.*;

public class BOJ2566 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        // 배열 입력값으로 초기화
        int[][] arr = new int[9][9];
        for (int row = 0; row < 9; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < 9; col++) {
                arr[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        int maxVal = Integer.MIN_VALUE;
        int resRow = 0, resCol = 0;
        // 최대값 구하는 로직
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int now = arr[row][col];
                if (now > maxVal) {
                    maxVal = now;
                    resRow = row + 1;
                    resCol = col + 1;
                }
            }
        }

        System.out.println(maxVal);
        System.out.println(resRow + " " + resCol);
    }
}