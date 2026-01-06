import java.io.*;
import java.util.*;

public class BOJ2468 {
    static boolean[][] visited;
    static class Pos {
        int row, col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 최대 높이와 배열 담기
        int maxH = 0;
        int[][] area = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, area[i][j]);
            }
        }
        int answer = 0;
        // 높이를 높이며 확인
        for (int hight = 0; hight < maxH; hight++) {
            int cnt = 0;
            visited = new boolean[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    // 방문하지 않고 높이보다 높은 경우 BFS
                    if (!visited[row][col] && area[row][col] > hight) {
                        Pos nowInfo = new Pos(row, col);
                        BFS(nowInfo, hight, area);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }

    private static void BFS(Pos start, int hight, int[][] area) {
        // 방향
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        // 방문 처리 및 덱 설정
        visited[start.row][start.col] = true;
        Deque<Pos> posDeque = new ArrayDeque<>();
        posDeque.addLast(start);
        // 탐색
        while (!posDeque.isEmpty()) {
            Pos now = posDeque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];
                // 범위 확인
                if (!canMove(nextRow, nextCol, area.length)) continue;
                // 방문 및 높이보다 큰 경우
                if (!visited[nextRow][nextCol] && area[nextRow][nextCol] > hight) {
                    visited[nextRow][nextCol] = true;
                    posDeque.addLast(new Pos(nextRow, nextCol));
                }
            }
        }
    }

    private static boolean canMove(int row, int col, int size) {
        return (0 <= row && row < size) && (0 <= col && col < size);
    }
}
