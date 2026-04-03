import java.io.*;
import java.util.*;

public class BOJ9727 {
    static boolean[] visited = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int test = 1; test <= testCase; test++) {
            int[][] sudoku = new int[6][6];
            for (int r = 0; r < 6; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < 6; c++) {
                    sudoku[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Case#")
                    .append(test)
                    .append(": ")
                    .append(isPossible(sudoku))
                    .append("\n");
        }
        System.out.println(sb);
    }

    private static int isPossible(int[][] sudoku) {
        // 대각선 검사
        if (!checkDiagonal(sudoku)) {
            return 0;
        }
        // 가로선 검사
        if (!checkHorizontal(sudoku)) {
            return 0;
        }
        // 세로선 검사
        if (!checkVertical(sudoku)) {
            return 0;
        }
        // 2 * 3 범위 체크
        for (int i = 0; i < 3; i++) {
            int r = 2 * i;
            for (int j = 0; j < 2; j++) {
                int c = 3 * j;
                if (!checkSquare(sudoku, r, c)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    private static boolean checkSquare(int[][] sudoku, int startR, int startC) {
        // 사각 범위 검사
        Arrays.fill(visited, false);
        for (int r = startR; r < startR + 2; r++) {
            for (int c = startC; c < startC + 3; c++) {
                if (visited[sudoku[r][c]]) {
                    return false;
                }
                visited[sudoku[r][c]] = true;
            }
        }
        return true;
    }

    private static boolean checkVertical(int[][] sudoku) {
        // 전체 세로선 검사
        for (int c = 0; c < 6; c++) {
            Arrays.fill(visited, false);
            for (int r = 0; r < 6; r++) {
                if (visited[sudoku[r][c]]) {
                    return false;
                }
                visited[sudoku[r][c]] = true;
            }
        }
        return true;
    }

    private static boolean checkHorizontal(int[][] sudoku) {
        // 전체 가로선 검사
        for (int r = 0; r < 6; r++) {
            Arrays.fill(visited, false);
            for (int c = 0; c < 6; c++) {
                if (visited[sudoku[r][c]]) {
                    return false;
                }
                visited[sudoku[r][c]] = true;
            }
        }
        return true;
    }

    private static boolean checkDiagonal(int[][] sudoku) {
        // 왼쪽 위부터 오른쪽 아래 검사
        Arrays.fill(visited, false);
        int r = 0, c = 0;
        for (int i = 0; i < 6; i++) {
            if (visited[sudoku[r][c]]) {
                return false;
            }
            visited[sudoku[r][c]] = true;
            r++;
            c++;
        }
        // 오른쪽 위부터 왼쪽 아래 검사
        Arrays.fill(visited, false);
        r = 0;
        c = 5;
        for (int i = 0; i < 6; i++) {
            if (visited[sudoku[r][c]]) {
                return false;
            }
            visited[sudoku[r][c]] = true;
            r++;
            c--;
        }
        return true;
    }
}
