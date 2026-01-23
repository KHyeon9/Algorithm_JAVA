import java.io.*;
import java.util.*;

public class BOJ6593 {
    static class Pos {
        int height, row, col, time;

        public Pos (int height, int row, int col, int time) {
            this.height = height;
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    static int heightSize;
    static int rowSize;
    static int colSize;
    static char[][][] building;
    static boolean[][][] visited;
    static int[] dHeight = {-1, 1, 0, 0, 0, 0};
    static int[] dRow = {0, 0, -1, 1, 0, 0};
    static int[] dCol = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            heightSize = Integer.parseInt(st.nextToken());
            rowSize = Integer.parseInt(st.nextToken());
            colSize = Integer.parseInt(st.nextToken());

            if (heightSize == 0 && rowSize == 0 && colSize == 0) {
                break;
            }
            // visited 셋팅
            visited = new boolean[heightSize][rowSize][colSize];
            // 빌딩 받기
            Pos start = new Pos(0, 0, 0, 0);
            Pos end = new Pos(0, 0, 0, 0);
            building = new char[heightSize][rowSize][colSize];
            for (int h = 0; h < heightSize; h++) {
                for (int r = 0; r < rowSize; r++) {
                    String line = br.readLine();
                    for (int c = 0; c < colSize; c++) {
                        building[h][r][c] = line.charAt(c);
                        if (building[h][r][c] == 'S') {
                            start = new Pos(h, r, c, 0);
                        }
                        if (building[h][r][c] == 'E') {
                            end = new Pos(h, r, c, 0);
                        }
                    }
                }
                br.readLine();
            }

            int answer = getEscapeTime(start, end);
            if (answer == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.printf("Escaped in %d minute(s).\n", answer);
            }
        }
        br.close();
    }

    private static int getEscapeTime(Pos start, Pos end) {
        // visited 및 덱 셋팅
        visited[start.height][start.row][start.col] = true;
        Deque<Pos> posDeq = new ArrayDeque<>();
        posDeq.addLast(start);
        // 탐색
        while (!posDeq.isEmpty()) {
            Pos now = posDeq.pollFirst();
            // 탈출한 경우 반환
            if (isEscape(now, end)) {
                return now.time;
            }
            for (int i = 0; i < 6; i++) {
                int nextHeight = now.height + dHeight[i];
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];
                // 이동 가능하고 방문하지 않은 경우
                if (canMove(nextHeight, nextRow, nextCol) && 
                        !visited[nextHeight][nextRow][nextCol]) {
                    // 방문 처리 및 시간 증가하여 덱에 넣기
                    visited[nextHeight][nextRow][nextCol] = true;
                    posDeq.addLast(
                            new Pos(nextHeight, nextRow, nextCol, now.time + 1)
                    );
                }
            }
        }
        return -1;
    }

    private static boolean canMove(int height, int row, int col) {
        // 범위를 벗어난 경우 false
        if ((0 > height || height >= heightSize) ||
                (0 > row || row >= rowSize) ||
                (0 > col || col >= colSize)) {
            return false;
        }
        // 위치가 빈 공간이거나 탈출 위치면 ture
        char now = building[height][row][col];
        return now == '.' || now == 'E';
    }
    // 탈출했는지 확인
    private static boolean isEscape(Pos now, Pos end) {
        return now.height == end.height &&
                now.row == end.row &&
                now.col == end.col;
    }
}
