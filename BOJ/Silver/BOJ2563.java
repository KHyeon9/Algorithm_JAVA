import java.io.*;
import java.util.*;

public class BOJ2563 {
    static int[][] paper;

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        paper = new int[101][101];

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            cover(row, col);
        }
        // 덮힌 부분 구하기
        int answer = 0;
        for (int row = 1; row <= 100; row++) {
            for (int col = 1; col <= 100; col++) {
                if (paper[row][col] == 1)
                    answer++;
            }
        }

        System.out.println(answer);
    }
    // 색종이 덮기
    private static void cover(int row, int col) {
        for (int i = row; i < row + 10; i++) {
            for (int j = col; j < col + 10; j++) {
                paper[i][j] = 1;
            }
        }
    }
}
