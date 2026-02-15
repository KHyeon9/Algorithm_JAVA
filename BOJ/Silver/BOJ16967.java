import java.io.*;
import java.util.*;

public class BOJ16967 {
    static int height;
    static int width;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        // 변형된 배열 크기
        int totalRow = height + x;
        int totalCol = width + y;
        // 변형된 배열 받기
        int[][] arr = new int[totalRow][totalCol];
        for (int r = 0; r < totalRow; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < totalCol; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // 배열 복구 및 출력
        // 변형된 배열 값에 복구한 배열의 (r - x, c - y)위치의 값 빼주기
        StringBuilder answer = new StringBuilder();
        int[][] decodeArr = new int[height][width];
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                int decodeRow = r - x;
                int decodeCol = c - y;
                // 디코딩에 사용할 숫자의 위치가 범위를 넘지 않은경우
                if (isOk(decodeRow, decodeCol)) {
                    // 해당 위치의 숫자를 빼줌
                    decodeArr[r][c] = arr[r][c] - decodeArr[decodeRow][decodeCol];
                } else {
                    // 범위를 넘은 경우는 기존값 넣기
                    decodeArr[r][c] = arr[r][c];
                }
                answer.append(decodeArr[r][c]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    private static boolean isOk(int row, int col) {
        return (0 <= row && row < height) && (0 <= col && col < width);
    }
}
