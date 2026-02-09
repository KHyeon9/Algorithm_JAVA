import java.io.*;
import java.util.*;

public class BOJ2508 {
    static int rowSize;
    static int colSize;
    static char[][] candyBox;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int test = 0; test < testCase; test++) {
            String line = br.readLine();
            // 데이터가 있는 줄이 나올 때까지 무한 반복해서 읽기
            while (line == null || line.trim().isEmpty()) {
                line = br.readLine();
            }
            StringTokenizer st = new StringTokenizer(line);
            rowSize = Integer.parseInt(st.nextToken());
            colSize = Integer.parseInt(st.nextToken());
            // 캔디 박스 셋팅
            candyBox = new char[rowSize][colSize];
            for (int r = 0; r < rowSize; r++) {
                String row = br.readLine();
                for (int c = 0; c < colSize; c++) {
                    candyBox[r][c] = row.charAt(c);
                }
            }

            int answer = 0;
            for (int r = 0; r < rowSize; r++) {
                for (int c = 0; c < colSize; c++) {
                    // 캔디가 있는 경우 껍질 확인
                    if (candyBox[r][c] == 'o' && isCandy(r, c)) {
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
        br.close();
    }

    private static boolean isCandy(int r, int c) {
        // 가로 검사
        if (chackCandy(r, c -1, '>') && chackCandy(r, c + 1, '<') ) {
           return true;
        }
        // 세로 검사
        if (chackCandy(r - 1, c, 'v') && chackCandy(r + 1, c, '^') ) {
            return true;
        }
        return false;
    }

    private static boolean chackCandy(int r, int c, char cover) {
        // 범위 확인
        if (!isMove(r, c)) {
            return false;
        }
        // 해당 위치에 맞는 껍질인지 확인
        return candyBox[r][c] == cover;
    }

    private static boolean isMove(int r, int c) {
        return (0 <= r && r < rowSize) && (0 <= c && c < colSize);
    }
}
