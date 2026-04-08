import java.io.*;
import java.util.*;

public class BOJ34386 {
    static class EmptyPos {
        int row, col;

        public EmptyPos (int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String toString() {
            return (row + 1) + " " + (col + 1);
        }
    }
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        char nowPlayer = br.readLine().charAt(0);

        board = new char[3][3];
        for (int r = 0; r < 3; r++) {
            String line = br.readLine();
            for (int c = 0; c < 3; c++) {
                board[r][c] = line.charAt(c);
            }
        }
        // 출력
        EmptyPos answer = getWinPos(nowPlayer);
        System.out.println(answer != null ? answer.toString() : "Fail");
    }

    private static EmptyPos getWinPos(char nowPlayer) {
        int[] signCnt = new int[4];
        // 수평 및 수직 검사
        for (int i = 0; i < 3; i++) {
            Arrays.fill(signCnt, 0);
            EmptyPos horizonEmptyPos = null;
            EmptyPos perpendEmptyPos = null;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'E') {
                    signCnt[1]++;
                    horizonEmptyPos = new EmptyPos(i, j);
                } else if (board[i][j] == nowPlayer) {
                    signCnt[0]++;
                }

                if (board[j][i] == 'E') {
                    signCnt[3]++;
                    perpendEmptyPos = new EmptyPos(j, i);
                } else if (board[j][i] == nowPlayer) {
                    signCnt[2]++;
                }
            }
            // 가로로 가능한 경우 반환
            if (signCnt[0] == 2 && signCnt[1] == 1) {
                return horizonEmptyPos;
            }
            // 세로로 가능한 경우 반환
            if (signCnt[2] == 2 && signCnt[3] == 1) {
                return perpendEmptyPos;
            }
        }
        // 대각선 검사
        Arrays.fill(signCnt, 0);
        EmptyPos leftCrossEmptyPos = null;
        EmptyPos rightCrossEmptyPos = null;
        int r = 0, c = 0;
        for (int i = 0; i < 3; i++) {
            if (board[r][c] == nowPlayer) {
                signCnt[0]++;
            } else if (board[r][c] == 'E') {
                signCnt[1]++;
                leftCrossEmptyPos = new EmptyPos(r, c);
            }
            if (board[r][2 - c] == nowPlayer) {
                signCnt[2]++;
            } else if (board[r][2 - c] == 'E') {
                signCnt[3]++;
                rightCrossEmptyPos = new EmptyPos(r, 2 - c);
            }
            r++;
            c++;
        }
        // 왼쪽 대각선 가능한 경우 반환
        if (signCnt[0] == 2 && signCnt[1] == 1) {
            return leftCrossEmptyPos;
        }
        // 오른쪽 대각선 가능한 경우 반환
        if (signCnt[2] == 2 && signCnt[3] == 1) {
            return rightCrossEmptyPos;
        }
        return null;
    }
}
