import java.util.*;
import java.io.*;

public class BOJ27982 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[n + 1][n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[h][r][c] = 1;
        }

        int answer = 0;
        for (int h = 1; h <= n; h++) {
            for (int r = 1; r <= n; r++) {
                for (int c = 1; c <= n; c++) {
                    if (arr[h][r][c] == 1) {
                        if (isOk(arr, h, r, c, n)) answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean isOk(int[][][] arr, int height, int row, int col, int size) {
        int[] dHeight = {-1, 1, 0, 0, 0, 0};
        int[] dRow = {0, 0, -1, 1, 0, 0};
        int[] dCol = {0, 0, 0, 0, -1, 1};

        for (int i = 0; i < 6; i++) {
            int nextHeight = height + dHeight[i];
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            // 이동이 불가능하면 false
            if (!canMove(nextHeight, nextRow, nextCol, size)) {
                return false;
            }
            // 주면 큐브가 없으면 false
            if (arr[nextHeight][nextRow][nextCol] != 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean canMove(int height, int row, int col, int size) {
        return (0 < height && height <= size) &&
                (0 < row && row <= size) &&
                (0 < col && col <= size);
    }
}
