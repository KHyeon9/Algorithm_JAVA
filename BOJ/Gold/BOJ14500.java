import java.io.*;
import java.util.*;

public class BOJ14500 {
    static class PosInfo {
        int row, col;

        public PosInfo(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static int rowSize;
    static int colSize;
    static boolean[][] visited;
    static int[][] paper;
    static int cnt;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        // visited 셋팅
        visited = new boolean[rowSize][colSize];
        // paper 셋팅
        paper = new int[rowSize][colSize];
        for (int r = 0; r < rowSize; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < colSize; c++) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        int maxSum = 0;
        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                cnt = 0;
                // 백트랙킹
                visited[r][c] = true;
                DFS(0, r, c, paper[r][c]);
                visited[r][c] = false;
                // t자와 나머지 도형 비교
                int nowMaxSum = Math.max(chackT(r, c), cnt);
                // 전체 max값과 비교
                maxSum = Math.max(maxSum, nowMaxSum);
            }
        }
        System.out.println(maxSum);
    }
    // T모양은 상하좌우 움직이면서 만들기엔 돌아와야 하는 부분이 있음
    // 그래서 따로 계산해야 함
    private static int chackT(int r, int c) {
        int sum = paper[r][c];
        int minNum = Integer.MAX_VALUE;
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nextRow = r + dRow[i];
            int nextCol = c + dCol[i];
            // 4개 방향을 다 확인하면 +모양
            // 가장 작은 값을 빼주면 max값 찾을 수 있음
            if (isMove(nextRow, nextCol)) {
                int now = paper[nextRow][nextCol];
                sum += now;
                minNum = Math.min(minNum, now);
                cnt++;
            }
        }
        // 4개면 가장 작은 값 빼주기
        if (cnt == 4) {
            return sum - minNum;
        } else if (cnt == 3) {
            // 3개인 경우 T자 모양 완성이므로 그대로 반환
            return sum;
        } else {
            // 다 안되면 안되므로 0 반환
            return 0;
        }
    }

    private static void DFS(int depth, int row, int col, int sum) {
        // 인접한 4칸의 합인 경우 계산
        if (depth == 3) {
            cnt = Math.max(cnt, sum);
            return;
        }
        // 4 방향 탐색
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            // 이동 가능하고 방문하지 않은 경우
            if (isMove(nextRow, nextCol) && !visited[nextRow][nextCol]) {
                // 백트래킹
                visited[nextRow][nextCol] = true;
                DFS(depth + 1, nextRow, nextCol, sum + paper[nextRow][nextCol]);
                visited[nextRow][nextCol] = false;
            }
        }
    }
    // 이동 가능한지 확인
    private static boolean isMove(int row, int col) {
        return (0 <= row && row < rowSize) && (0 <= col && col < colSize);
    }
}
