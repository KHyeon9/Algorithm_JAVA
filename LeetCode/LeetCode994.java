import java.io.*;
import java.util.*;

class LeetCode994 {
    class Pos {
        int row, col, min;

        public Pos (int row, int col, int min) {
            this.row = row;
            this.col = col;
            this.min = min;
        }
    }
    // 이동 방향 셋팅
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public int orangesRotting(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        // 썩은 과일 위치를 시작점으로 저장
        List<Pos> startPos = new ArrayList<>();
        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (grid[r][c] == 2) {
                    startPos.add(new Pos(r, c, 0));
                }
            }
        }
        int totalMin = 0;
        // 시작점 셋팅
        Deque<Pos> posDeq = new ArrayDeque<>();
        for (Pos p : startPos) {
            posDeq.addLast(p);
        }
        // BFS 탐색
        while (!posDeq.isEmpty()) {
            Pos now = posDeq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if (isMove(nextRow, nextCol, rowSize, colSize) && grid[nextRow][nextCol] == 1) {
                    grid[nextRow][nextCol] = 2;
                    Pos next = new Pos(nextRow, nextCol, now.min + 1);
                    posDeq.addLast(next);
                    totalMin = Math.max(totalMin, next.min);
                }
            }
        }
        // 살아있는 과일 있는지 확인
        for (int[] ints : grid) {
            for (int c = 0; c < colSize; c++) {
                if (ints[c] == 1) return -1;
            }
        }
        return totalMin;
    }
    // 이동 가능한지 확인
    private static boolean isMove(int row, int col, int rowSize, int colSize) {
        return (0 <= row && row < rowSize) && (0 <= col && col < colSize);
    }
}