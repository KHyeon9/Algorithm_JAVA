public class LeetCode3898 {
    // Find the Degree of Each Vertex
    public int[] findDegrees(int[][] matrix) {
        int[] ans = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int cnt = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                cnt += matrix[i][j];
            }
            ans[i] = cnt;
        }
        return ans;
    }
}
