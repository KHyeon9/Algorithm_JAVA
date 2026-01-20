import java.io.*;
import java.util.*;

public class BOJ18221 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] classroom = new int[n][n];
        int profRow = 0, profCol = 0;
        int sungRow = 0, sungCol = 0;
        for (int row = 0; row < n; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                classroom[row][col] = Integer.parseInt(st.nextToken());
                // 교수님 위치 저장
                if (classroom[row][col] == 5) {
                    profRow = row;
                    profCol = col;
                }
                // 성규 위치 저장
                else if (classroom[row][col] == 2) {
                    sungRow = row;
                    sungCol = col;
                }
            }
        }

        System.out.println(isRun(profRow, profCol, sungRow, sungCol, classroom));
    }
    // 탈출 가능한지 확인
    private static int isRun(
            int profRow, int profCol, int sungRow, int sungCol, int[][] classroom
    ) {
        // 루트를 해야하나 제곱값이므로 25보다 작으면 0
        int dist = getDist(profRow - sungRow, profCol - sungCol);
        if (dist < 25) return 0;
        // 교수님과 성규 사이 학생 수 저장
        int studentCnt = 0;
        for (int row = Math.min(profRow, sungRow); row <= Math.max(profRow, sungRow); row++) {
            for (int col = Math.min(profCol, sungCol); col <= Math.max(profCol, sungCol); col++) {
                if (classroom[row][col] == 1) {
                    studentCnt++;
                }
            }
        }
        // 3이상이면 1 아니면 0
        return studentCnt >= 3 ? 1 : 0;
    }
    // 거리 구하기
    private static int getDist (int num1, int num2) {
        return num1 * num1 + num2 * num2;
    }
}
