import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode733 {
    // Flood Fill
    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    // 상하좌우 이동 방향
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        // 변경색과 같은 경우
        if (startColor == color) return image;
        // 사이즈
        int rowSize = image.length;
        int colSize = image[0].length;
        // 초기 셋팅
        Deque<Position> deq = new ArrayDeque<>();
        deq.push(new Position(sr, sc));
        image[sr][sc] = color;

        while (!deq.isEmpty()) {
            Position curr = deq.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = curr.row + dx[i];
                int nextCol = curr.col + dy[i];
                // 색 변경되는 경우
                if (isMove(nextRow, nextCol, rowSize, colSize) && image[nextRow][nextCol] == startColor) {
                    image[nextRow][nextCol] = color;
                    deq.push(new Position(nextRow, nextCol));
                }
            }
        }
        return image;
    }
    // 이동 가능 확인
    private boolean isMove(int row, int col, int rowSize, int colSize) {
        return (0 <= row && row < rowSize && 0 <= col && col < colSize);
    }
}
