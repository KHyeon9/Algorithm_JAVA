public class LeetCode2373 {
    // Largest Local Values in a Matrix
    public int[][] largestLocal(int[][] grid) {
        int size = grid.length - 2;
        int[][] ans = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int maxVal = 0;
                // 3 * 3 영역 탐색
                for (int i = row; i <= row + 2; i++) {
                    for (int j = col; j <= col + 2; j++) {
                        maxVal = Math.max(maxVal, grid[i][j]);
                    }
                }
                ans[row][col] = maxVal;
            }
        }
        return ans;
    }
}

