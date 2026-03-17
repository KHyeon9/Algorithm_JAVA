import java.io.*;

public class BOJ3010 {
    static char[][] board = new char[7][7];
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        // 보드 입력 받기
        for (int r = 0; r < 7; r++) {
            String row = br.readLine();
            for (int c = 0; c < 7; c++) {
                board[r][c] = row.charAt(c);
            }
        }
        br.close();
        // 이동 갯수 세기
        int moveCnt = 0;
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 7; c++) {
                if (board[r][c] == '.') {
                    moveCnt += getPosMoveCnt(r, c);
                }
            }
        }
        System.out.println(moveCnt);
    }
    // 이동 가능 갯수
    private static int getPosMoveCnt(int r, int c) {
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            int rRange = r + dRow[i] * 2;
            int cRange = c + dCol[i] * 2;
            // 범위 안인지 확인
            if (isOk(rRange, cRange)) {
                if (board[r + dRow[i]][c + dCol[i]] == 'o' &&
                        board[r + dRow[i] * 2][c + dCol[i] * 2] == 'o') {
                    answer++;
                }
            }
        }
        return answer;
    }
    // 가능한 것인지
    private static boolean isOk(int r, int c) {
        return (0 <= r && r < 7) && (0 <= c && c < 7);
    }
}
