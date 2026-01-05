import java.util.*;
import java.io.*;

public class BOJ1600 {
    // 점프 횟수 상태 저장하기 위한 3차원 배열
    static boolean[][][] visited;
    static int[][] map;
    // 원숭이의 현재 상태 저장을 위한 객체
    static class MongkeyInfo {
        int row, col, dist, jumpCnt;

        public MongkeyInfo(int row, int col, int dist, int jumpCnt) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.jumpCnt = jumpCnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 전체 점프 횟수 입력
        int totalJumCnt = Integer.parseInt(br.readLine());
        // 가로 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        int colSize = Integer.parseInt(st.nextToken());
        int rowSize = Integer.parseInt(st.nextToken());
        // visited 초기화 총 totalJumCnt와 한번도 안뛴 상태까지 해서 +1해야함
        visited = new boolean[totalJumCnt + 1][rowSize][colSize];
        // map 초기화
        map = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < colSize; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        // 시작 원숭이 정보 셋팅 및 bfs로 탐색 및 출력
        MongkeyInfo start = new MongkeyInfo(0, 0, 0, 0);
        System.out.println(getShortDist(start, rowSize, colSize, totalJumCnt));
    }

    private static int getShortDist(MongkeyInfo startInfo, int rowSize, int colSize, int maxJump) {
        // 원숭이 이동 방향 셋팅
        int[] monkeyMoveRow = {-1, 1, 0, 0};
        int[] monkeyMoveCol = {0, 0, -1, 1};
        // 말처럼 이동 방향 셋팅
        int[] jumpMoveRow = {-2, -2, -1, 1, 2, 2, -1, 1};
        int[] jumpMoveCol = {-1, 1, -2, -2, -1, 1, 2, 2};
        // 시작점 초기화
        visited[0][0][0] = true;
        // 덱으로 시작 원숭이 위치 저장
        Deque<MongkeyInfo> infoDeque = new ArrayDeque<>();
        infoDeque.addLast(startInfo);
        // 덱이 빌때까지 탐색
        while (!infoDeque.isEmpty()) {
            MongkeyInfo nowInfo = infoDeque.pollFirst();
            // 도착지면 최소 거리 반환
            if (nowInfo.row == rowSize - 1 && nowInfo.col == colSize - 1) {
                return nowInfo.dist;
            }
            // 원숭이 이동 방향 탐색
            for (int i = 0; i < 4; i++) {
                searchProcess(
                        infoDeque,
                        nowInfo,
                        monkeyMoveRow,
                        monkeyMoveCol,
                        rowSize,
                        colSize,
                        false
                );
            }

            // 점프 횟수가 남은 경우 말처럼 이동 방향 탐색
            if (nowInfo.jumpCnt < maxJump) {
                searchProcess(
                        infoDeque,
                        nowInfo,
                        jumpMoveRow,
                        jumpMoveCol,
                        rowSize,
                        colSize,
                        true
                );
            }
        }

        return -1;
    }
    // 탐색 로직
    private static void searchProcess (
            Deque<MongkeyInfo> infoDeque,
            MongkeyInfo nowInfo,
            int[] dRow, int[] dCol,
            int rowSize, int colSize,
            boolean isJump
    ) {
        int moveLength = dRow.length;
        for (int i = 0; i < moveLength; i++) {
            int nextRow = nowInfo.row + dRow[i];
            int nextCol = nowInfo.col + dCol[i];
            // 이동 가능 확인
            if (!canMove(nextRow, nextCol, rowSize, colSize)) {
                continue;
            }
            // 방문 여부 확인 및 벽인지 확인
            int nextJumpCnt = nowInfo.jumpCnt + (isJump ? 1 : 0);
            if (!visited[nextJumpCnt][nextRow][nextCol] &&
                    map[nextRow][nextCol] != 1) {
                visited[nextJumpCnt][nextRow][nextCol] = true;
                infoDeque.addLast(new MongkeyInfo(nextRow, nextCol, nowInfo.dist + 1, nextJumpCnt));
            }
        }
    }

    // 이동 가능 범위 확인
    private static boolean canMove(int row, int col, int rowSize, int colSize) {
        return (0 <= row && row < rowSize) && (0 <= col && col < colSize);
    }
}
