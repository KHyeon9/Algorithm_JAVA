import java.util.*;

public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                // 왼쪽 경로 횟수
                int leftCnt = (c - 1) < 0 ? 0 : grid[r][c - 1];
                // 윗쪽 경로 횟수
                int upCnt = (r - 1) < 0 ? 0 : grid[r - 1][c];
                // 경로 합
                int total = leftCnt + upCnt;
                // 경로가 0이면 1 반환
                grid[r][c] = total == 0 ? 1 : total;
            }
        }
        return grid[n - 1][m - 1];
    }
}
