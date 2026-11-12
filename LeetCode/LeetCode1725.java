public class LeetCode1725 {
    // Number Of Rectangles That Can Form The Largest Square
    public int countGoodRectangles(int[][] rectangles) {
        int len = rectangles.length;
        int[] squares = new int[len];
        int max = 0;

        for (int i = 0; i < len; i++) {
            squares[i] = Math.min(rectangles[i][0], rectangles[i][1]);
            max = Math.max(max, squares[i]);
        }

        int cnt = 0;
        for (int extent : squares) {
            cnt += extent == max ? 1 : 0;
        }
        return cnt;
    }
}

