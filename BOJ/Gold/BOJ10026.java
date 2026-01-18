import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ10026 {
    static class PosInfo {
        int row, col;

        public PosInfo (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        char[][] art = new char[size][size];
        for (int i = 0; i < size; i++) {
            String row = br.readLine();
            for (int j = 0; j < size; j++) {
                art[i][j] = row.charAt(j);
            }
        }
        // answer 변수 선언
        int answer1 = 0;
        int answer2 = 0;
        // 일반인 visited 셋팅
        visited = new boolean[size][size];
        // 일반인 그림 탐색 (BFS)
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (!visited[row][col]) {
                    PosInfo start = new PosInfo(row, col);
                    findSection(start, art);
                    answer1++;
                }
            }
        }
        // 적록 색약 그림 변경
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (art[row][col] == 'G') {
                    art[row][col] = 'R';
                }
            }
        }
        // 적록 색약 visited 초기화
        visited = new boolean[size][size];
        // 적록 색약 구역 탐색
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (!visited[row][col]) {
                    PosInfo start = new PosInfo(row, col);
                    findSection(start, art);
                    answer2++;
                }
            }
        }
        System.out.println(answer1 + " " + answer2);
    }

    private static void findSection(PosInfo posInfo, char[][] art) {
        // 이동 방향
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        // 색 확인
        char color = art[posInfo.row][posInfo.col];
        // 방문 처리 및 덱 셋팅
        visited[posInfo.row][posInfo.col] = true;
        Deque<PosInfo> posDeq = new ArrayDeque<>();
        posDeq.addLast(posInfo);
        // 탐색
        while (!posDeq.isEmpty()) {
            PosInfo now = posDeq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];
                // 범위 확인
                if (!canMove(nextRow, nextCol, art.length)) {
                    continue;
                }
                // 미방문이고 같은 색상이면 탐색
                if (!visited[nextRow][nextCol] &&
                    art[nextRow][nextCol] == color
                ) {
                    visited[nextRow][nextCol] = true;
                    posDeq.addLast(new PosInfo(nextRow, nextCol));
                }
            }
        }
    }

    private static boolean canMove(int row, int col, int size) {
        return (0 <= row && row < size) && (0 <= col && col < size);
    }
}
