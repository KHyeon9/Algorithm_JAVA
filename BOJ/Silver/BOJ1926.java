import java.io.*;
import java.util.*;

public class BOJ1926 {
    static class Pos {
        int row, col;

        public Pos (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    // 탐색 방향 셋팅
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static int rowSize;
    static int colSize;
    static boolean[][] visited;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        // 도화지 셋팅
        paper = new int[rowSize][colSize];
        for (int r = 0; r < rowSize; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < colSize; c++) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // visited 셋팅
        visited = new boolean[rowSize][colSize];
        // 탐색
        int artCnt = 0, maxSize = 0;
        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                // 방문하지 않고 그림인지 확인
                if (!visited[r][c] && paper[r][c] == 1) {
                    artCnt++;
                    maxSize = Math.max(maxSize, getArtSize(new Pos(r, c)));
                }
            }
        }
        // 출력
        System.out.println(artCnt);
        System.out.println(maxSize);
    }

    private static int getArtSize(Pos start) {
        // 현재 방문 처리 및 크기 1증가
        int answer = 1;
        visited[start.row][start.col] = true;
        // 덱 셋팅
        Deque<Pos> posDeq = new ArrayDeque<>();
        posDeq.addLast(start);
        // 탐색
        while (!posDeq.isEmpty()) {
            Pos now = posDeq.pollFirst();
            // 다음 위치 화인
            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if (isMove(nextRow, nextCol) &&
                        !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    posDeq.addLast(new Pos(nextRow, nextCol));
                    answer++;
                }
            }
        }
        return answer;
    }
    // 이동 가능 위치 확인
    private static boolean isMove(int row, int col) {
        return (0 <= row && row < rowSize) &&
                (0 <= col && col < colSize) &&
                paper[row][col] == 1;
    }
}
