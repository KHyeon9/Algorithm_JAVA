import java.io.*;
import java.util.*;

public class BOJ1987 {
    static int rowSize;
    static int colSize;
    static char[][] board;
    static int answer = 0;
    static Set<Character> alpaSet =  new HashSet<>();
    // 이동 방향
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        // board setting
        board = new char[rowSize][colSize];
        for (int r = 0; r < rowSize; r++) {
            String line = br.readLine();
            for (int c = 0; c < colSize; c++) {
                board[r][c] = line.charAt(c);
            }
        }
        // DFS
        alpaSet.add(board[0][0]);
        DFS(1, 0, 0);
        System.out.println(answer);
    }

    private static void DFS(int cnt, int row, int col) {
        // 최대값 계산
        answer = Math.max(answer, cnt);

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            // 이동 가능하고 지나간 알파벳이 아닌 경우 백트랙킹
            if (isMove(nextRow, nextCol) && !alpaSet.contains(board[nextRow][nextCol])) {
                alpaSet.add(board[nextRow][nextCol]);
                DFS(cnt + 1, nextRow, nextCol);
                alpaSet.remove(board[nextRow][nextCol]);
            }
        }
    }

    private static boolean isMove(int row, int col) {
        return (0 <= row && row < rowSize) && (0 <= col && col < colSize);
    }
}
