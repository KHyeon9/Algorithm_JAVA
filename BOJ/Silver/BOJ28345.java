import java.io.*;
import java.util.*;

public class BOJ28345 {
    static int rowSize;
    static int colSize;
    static int[][] bitMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int test = 0; test < testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rowSize = Integer.parseInt(st.nextToken());
            colSize = Integer.parseInt(st.nextToken());
            // 비트맵 저장
            bitMap = new int[rowSize][colSize];
            for (int row = 0; row < rowSize; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < colSize; col++) {
                    bitMap[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            // 각 row마다 필터 번호와 최소값 계산 및 출력
            for (int row = 0; row < rowSize; row++) {
                int[] rowResult = new int[colSize * 2];
                for (int col = 0; col < colSize; col++) {
                    int[] calcValue = getValue(row, col);
                    for (int i = 0; i < 2; i++) {
                        rowResult[2 * col + i] = calcValue[i];
                    }
                }
                // 출력
                StringBuilder print = new StringBuilder();
                for (int val : rowResult) {
                    print.append(val).append(" ");
                }
                System.out.println(print);
            }
            
        }
    }
    // 예측값 구하는 메소드
    private static int[] getValue(int row, int col) {
        int now = bitMap[row][col];
        // 예측 필터값 계산
        int a = isPossible(row, col - 1) ? bitMap[row][col - 1] : 0;
        int b = isPossible(row - 1, col) ? bitMap[row - 1][col] : 0;
        int c = isPossible(row - 1, col - 1) ? bitMap[row - 1][col - 1] : 0;
        // 필터에 따른 예측값 계산
        int[] calcFilter= {0, a, b, (a + b) / 2, a + b - c};
        // 최소값 찾기
        int[] answer = new int[2];
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            int gap = now - calcFilter[i];
            int absGap = Math.abs(gap);
            if (minVal > absGap) {
                minVal = absGap;
                answer[0] = i;
                answer[1] = gap;
            }
        }
        return answer;
    }
    // 범위 확인
    private static boolean isPossible(int row, int col) {
        return (0 <= row && row < rowSize) && (0 <= col && col < colSize);
    }
}
