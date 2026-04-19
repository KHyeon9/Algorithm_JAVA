import java.io.*;
import java.util.*;

public class BOJ14680 {
    static int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        // 첫 배열 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        int currRow = Integer.parseInt(st.nextToken());
        int currCol = Integer.parseInt(st.nextToken());
        long[][] answerArr = new long[currRow][currCol];
        for (int r = 0; r < currRow; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < currCol; c++) {
                answerArr[r][c] = Long.parseLong(st.nextToken());
            }
        }
        // 다음 배열과 계산
        boolean isOk = true;
        for (int i = 1; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());
            long[][] calcArr = new long[rowSize][colSize];
            for (int r = 0; r < rowSize; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < colSize; c++) {
                    calcArr[r][c] = Long.parseLong(st.nextToken());
                }
            }
            // 계산이 불가능하면 상태 변경
            if (currCol != rowSize) {
                isOk = false;
            }
            // 불가능하면 계산을 추가로 하지 않음
            if (!isOk) continue;
            // 계산
            long[][] temp = new long[currRow][colSize];
            for (int r = 0; r < currRow; r++) {
                for (int c = 0; c < colSize; c++) {
                    // 두 배열의 곱을 계산
                    for (int calc = 0; calc < currCol; calc++) {
                        temp[r][c] = (temp[r][c] + answerArr[r][calc] * calcArr[calc][c]) % MOD;
                    }
                }
            }
            answerArr = temp;
            currCol = colSize;
        }
        if (isOk) {
            // 계산된 배열 총합
            int answer = 0;
            for (int r = 0; r < currRow; r++) {
                for (int c = 0; c < currCol; c++) {
                    answer = (int) ((answer + answerArr[r][c]) % MOD);
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
