import java.io.*;
import java.util.*;

public class BOJ14442 {
    static class PosInfo {
        int row, col, breakCnt, dist;

        public PosInfo (int row, int col, int breakCnt, int dist) {
            this.row = row;
            this.col = col;
            this.breakCnt = breakCnt;
            this.dist = dist;
        }
    }
    // 이동 방향 셋팅
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, -1, 0, 1};
    // 편하게 사용하기 위한 static 변수 정의
    static boolean[][][] visited;
    static int rowSize;
    static int colSize;
    static int maxBreakCnt;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        maxBreakCnt = Integer.parseInt(st.nextToken());
        // visited 셋팅 (벽 부순 수를 상태로 z축으로 관리)
        visited = new boolean[maxBreakCnt + 1][rowSize][colSize];
        // map 받기
        map = new int[rowSize][colSize];
        for (int r = 0; r < rowSize; r++) {
            String line = br.readLine();
            for (int c = 0; c < colSize; c++) {
                map[r][c] = line.charAt(c) - '0';
            }
        }
        System.out.println(getMinDist(new PosInfo(0, 0, 0, 1)));
    }

    private static int getMinDist(PosInfo start) {
        // visited 및 덱 셋팅
        visited[start.breakCnt][start.row][start.col] = true;
        Deque<PosInfo> posDeq = new ArrayDeque<>();
        posDeq.addLast(start);
        // 탐색
        while (!posDeq.isEmpty()) {
            PosInfo now = posDeq.pollFirst();
            // 탈출한 경우 반환
            if (now.row == rowSize - 1 && now.col == colSize - 1) {
                return now.dist;
            }
            // 다음 이동 위치 탐색
            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];
                // 범위를 넘는지 확인
                if (isMove(nextRow, nextCol)) {
                    // 벽이면 1이므로 해당 값을 가지고 다음 상태로 갈지 결정
                    int isWall = map[nextRow][nextCol];
                    int nextBreakCnt = now.breakCnt + isWall;
                    // 벽 부순 횟수가 범위 안이고 방문하지 않은 경우
                    if (nextBreakCnt <= maxBreakCnt && !visited[nextBreakCnt][nextRow][nextCol]) {
                        visited[nextBreakCnt][nextRow][nextCol] = true;
                        posDeq.addLast(new PosInfo(nextRow, nextCol, nextBreakCnt, now.dist + 1));
                    }
                }
            }
        }

        return -1;
    }

    private static boolean isMove(int row, int col) {
        return (0 <= row && row < rowSize) &&
                (0 <= col && col < colSize);
    }
}
