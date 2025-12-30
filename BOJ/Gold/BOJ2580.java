import java.io.*;
import java.util.*;

public class BOJ2580 {
    static int[][] sudoku = new int[9][9];
    public static void main(String[] args) throws Exception{
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        // 스도쿠 배열 초기화
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 풀수 없는 입력은 없음
        // 스도쿠 풀기
        solveSudoku(0, 0);
        // 출력
        StringBuilder answer = new StringBuilder();
        for (int[] row : sudoku) {
            for (int col : row) {
                answer.append(col).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    private static boolean solveSudoku(int row, int col) {
        // col이 9를 넘는 경우
        if (col >= 9) {
            // 다음 줄로 넘어감
            return solveSudoku(row + 1, 0);
        }
        // row가 9를 넘는 경우는 모든 값을 입력한 경우
        if (row >= 9) {
            // true 반환
            return true;
        }
        // 비어있는 곳이 아니라며 패스
        if (sudoku[row][col] != 0) {
            return solveSudoku(row, col + 1);
        }
        // 해당 위치에 1 - 9까지 넣어보면서 확인
        for (int num = 1; num <= 9; num++) {
            // 해당값이 들어갈수 있는 경우
            if (isValid(row, col, num)) {
                sudoku[row][col] = num;
                // 스도쿠 결과가 충족되면 true로 빠져나가기
                if (solveSudoku(row, col + 1)) {
                    return true;
                }
                // 백트래킹 실패시 복구
                sudoku[row][col] = 0;
            }
        }
        // 스도쿠가 맞지 않으면 false
        return false;
    }

    private static boolean isValid(int row, int col, int num) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        // 3 * 3 사각형 안에 num이 존재하는지 확인
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == num) {
                    return false;
                }
            }
        }
        // 세로와 가로에서 num이 존재하는지 확인
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == num) {
                return false;
            }
            if (sudoku[i][col] == num) {
                return false;
            }
        }
        return true;
    }
}
