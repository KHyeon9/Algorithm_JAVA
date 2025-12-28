import java.io.*;
import java.util.*;

public class BOJ2447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 도화지 초기화
        char[][]drawingPaper = new char[n][n];
        for (char[] line : drawingPaper) {
            Arrays.fill(line, '*');
        }
        // 별그리기
        drawingStar(drawingPaper, 0, 0, n);
        // 출력
        StringBuilder answer = new StringBuilder();
        for (char[] line : drawingPaper) {
            for (char el : line) {
                answer.append(el);
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
    // 별그리기
    private static void drawingStar(
            char[][] paper,
            int row,
            int col,
            int size
    ) {
        if (size == 1) return;
        // 3으로 나눠서 변의 길이 셋팅
        int newSize = size / 3;
        // 중앙을 파내기 위해 3 * 3으로 나눠서 계산
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int newRow = row + i * newSize;
                int newCol = col + j * newSize;
                if (i == 1 && j == 1) {
                    // 중앙인 경우 파내기
                    fillBlank(paper, newRow, newCol, newSize);
                } else {
                    // 중앙이 아닌 경우 해당 부분 하위 파트 별그리기
                    drawingStar(paper, newRow, newCol, newSize);
                }
            }

        }
    }
    // 빈칸 파내기
    private static void fillBlank(char[][] paper, int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                paper[i][j] = ' ';
            }
        }
    }
}
