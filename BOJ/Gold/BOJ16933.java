import java.io.*;
import java.util.*;

public class BOJ16933 {
    static class PosInfo {
        int row, col, dist, breakCnt;
        boolean isNight;

        public PosInfo(int row, int col, int dist, int breakCnt, boolean isNight) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.isNight = isNight;
            this.breakCnt = breakCnt;
        }
    }
    static int rowSize;
    static int colSize;
    static int maxBreakCnt;
    static boolean[][][] visited;
    static int[][] map;
    // 이동 방향
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        maxBreakCnt = Integer.parseInt(st.nextToken());
        // visited init
        visited = new boolean[maxBreakCnt + 1][rowSize][colSize];
        // map setting
        map = new int[rowSize][colSize];
        for (int r = 0; r < rowSize; r++) {
            String line = br.readLine();
            for (int c = 0; c < colSize; c++) {
                map[r][c] = line.charAt(c) - '0';
            }
        }
        // start PosInfo setting
        PosInfo start = new PosInfo(0, 0, 1, 0, false);
        // print
        System.out.println(getMinDist(start));
    }

    private static int getMinDist(PosInfo start) {
        // visited check
        visited[start.breakCnt][start.row][start.col] = true;
        // deque setting
        Deque<PosInfo> posDeq = new ArrayDeque<>();
        posDeq.addLast(start);
        // search
        while (!posDeq.isEmpty()) {
            PosInfo now = posDeq.pollFirst();
            boolean isWait = false;
            // 도착시 거리 반환
            if (now.row == rowSize - 1 && now.col == colSize - 1) {
                return now.dist;
            }
            // 4 방향을 돌면서 탐색
            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if (isMove(nextRow, nextCol)) {
                    if (map[nextRow][nextCol] == 0) {
                        // 벽이 아니고 방문하지 않은 경우
                        if (!visited[now.breakCnt][nextRow][nextCol]) {
                            visited[now.breakCnt][nextRow][nextCol] = true;
                            posDeq.addLast(new PosInfo(
                                    nextRow, nextCol,
                                    now.dist + 1, now.breakCnt,
                                    !now.isNight)
                            );
                        }
                    } else {
                        // 벽 부수는 횟수가 남아있고 방문하지 않은 경우
                        int nextBreakCnt = now.breakCnt + 1;
                        if (nextBreakCnt <= maxBreakCnt && !visited[nextBreakCnt][nextRow][nextCol]) {
                            if (!now.isNight) {
                                // 낮인 경우 부수기
                                visited[nextBreakCnt][nextRow][nextCol] = true;
                                posDeq.addLast(new PosInfo(
                                        nextRow, nextCol,
                                        now.dist + 1, nextBreakCnt,
                                        !now.isNight)
                                );
                            } else {
                                // 밤이고 기다리고 있는 위치가 없은 경우
                                if (!isWait) {
                                    posDeq.addLast(new PosInfo(
                                            now.row, now.col,
                                            now.dist + 1, now.breakCnt,
                                            !now.isNight)
                                    );
                                    isWait = true; // 기다린 탐색 위치 존재 flag 처리
                                }
                            }
                        }
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
