import java.util.*;

class LeetCode1926 {
    static class Pos {
        int row, col, dist;

        public Pos (int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    // 이동 방향 셋팅
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public int nearestExit(char[][] maze, int[] entrance) {
        int rowSize = maze.length, colSize = maze[0].length;
        // 초기 셋팅
        boolean[][] visited = new boolean[rowSize][colSize];
        visited[entrance[0]][entrance[1]] = true;
        Deque<Pos> posDeq = new ArrayDeque<>();
        posDeq.addLast(new Pos(entrance[0], entrance[1], 0));

        while(!posDeq.isEmpty()) {
            Pos now = posDeq.pollFirst();
            // 현재 위치가 아니고 탈출인 경우 거리 반환
            if (now.dist > 0 && isExit(now.row, now.col, rowSize, colSize)) {
                return now.dist;
            }
            // 다음 위치 탐색
            for (int i = 0; i < 4; i++) {
                // 다음 위치 계산
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];
                // 이동 가능한지, 방문하지 않은 경우, 이동 가능 위치인 경우 탐색
                if (isMove(nextRow, nextCol, rowSize, colSize) &&
                        !visited[nextRow][nextCol] &&
                        maze[nextRow][nextCol] == '.') {
                    visited[nextRow][nextCol] = true;
                    posDeq.addLast(new Pos(nextRow, nextCol, now.dist + 1));
                }
            }
        }
        // 탈출 불가면 -1
        return -1;
    }
    // 탈출 조건
    private static boolean isExit(int row, int col, int rowSize, int colSize) {
        return row == 0 || col == 0 || row == rowSize - 1 || col == colSize - 1;
    }
    // 이동 조건
    private static boolean isMove(int row, int col, int rowSize, int colSize) {
        return (0 <= row && row < rowSize) && (0 <= col && col < colSize);
    }
}