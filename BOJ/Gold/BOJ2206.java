import java.util.*;
import java.io.*;

public class BOJ2206 {
    // 벽을 깨면 다시 못깨므로 2층으로 visited를 만들어 상태 체크
    static boolean[][][] visited;
    static int[][] map;
    // 위치 정보와 현재 거리, 벽을 부순 여부 체크를 위한 클래스 생성
    static class Posistion {
        int row, col, dist, broken;

        public Posistion(int row, int col, int dist, int broken) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.broken = broken;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // visited 초기화
        visited = new boolean[2][n][m];
        // map 초기화
        map = new int[n][m];
        for (int row = 0; row < n; row++) {
            String line = br.readLine();
            for (int col = 0; col < m; col++) {
                map[row][col] = (line.charAt(col)) - '0';
            }
        }
        // bfs로 최단거리 계산 및 출력
        Posistion startPos = new Posistion(0, 0, 1, 0);
        System.out.println(getShartestDist(startPos, n, m));
    }

    // BFS로 최단 거리 탐색
    private static int getShartestDist(Posistion pos, int rowSize, int colSize) {
        // 이동 방향 셋팅
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        // 시작 visited 방문
        visited[pos.broken][pos.row][pos.col] = true;
        // 덱에 시작 위치 정보 추가
        Deque<Posistion> posDeque = new ArrayDeque<>();
        posDeque.addLast(pos);
        // 덱이 빌때까지 반복
        while (!posDeque.isEmpty()) {
            Posistion nowPos = posDeque.pollFirst();
            // 현재 위치가 목적지안 경우 반환
            if (nowPos.row == rowSize - 1 &&
                    nowPos.col == colSize - 1) {
                return nowPos.dist;
            }
            // 상하 좌우 움직이면서 탐색
            for (int i = 0; i < 4; i++) {
                // 다음 위치 계산
                int nextRow = nowPos.row + dRow[i];
                int nextCol = nowPos.col + dCol[i];
                // 범위 확인
                if (!canMove(nextRow, nextCol, rowSize, colSize)) {
                    continue;
                }
                // 이동 위치가 벽이 아닌 겨우
                if (!visited[nowPos.broken][nextRow][nextCol]
                        && map[nextRow][nextCol] == 0) {
                    // 방문 처리
                    visited[nowPos.broken][nextRow][nextCol] = true;
                    // 현재 위치의 거리 + 1 해서 덱에 추가
                    posDeque.addLast(
                            new Posistion(nextRow, nextCol, nowPos.dist + 1, nowPos.broken)
                    );
                }
                // 이동 위치가 벽인 경우
                if (
                        nowPos.broken == 0 && map[nextRow][nextCol] == 1 &&
                                !visited[nowPos.broken][nextRow][nextCol]
                ) {
                    // 방문 처리
                    visited[1][nextRow][nextCol] = true;
                    // 현재 위치의 거리 + 1 해서 덱에 추가
                    posDeque.addLast(
                            new Posistion(nextRow, nextCol, nowPos.dist + 1, 1)
                    );
                }
            }
        }
        return -1;
    }
    // 이동 가능한지 체크
    private static boolean canMove(int row, int col, int rowSize, int colSize) {
        return (0 <= row && row < rowSize) && (0 <= col && col < colSize);
    }
}