import java.io.*;
import java.util.*;

public class BOJ7569 {
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        // visited 셋팅
        visited = new boolean[h][n][m];
        // tomatos 셋팅 및 익은 토마토 저장
        List<int[]> ripeTomatoPosList= new ArrayList<>();
        int[][][] tomatos = new int[h][n][m];
        for (int height = 0; height < h; height++) {
            for (int row = 0; row < n; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < m; col++) {
                    int nowTomato = Integer.parseInt(st.nextToken());
                    tomatos[height][row][col] = nowTomato;
                    // 현재 토마토가 익었으면 위치 저장
                    if (nowTomato == 1) {
                        int[] ripeTomatoPos = { height, row, col };
                        ripeTomatoPosList.add(ripeTomatoPos);
                    }
                }
            }
        }
        // bfs롤 틍해 전부 익는 시간 계산
        calcAllRipeDays(tomatos, ripeTomatoPosList, h, n, m);
        // 출력
        System.out.println(getAllRipeDays(tomatos, h, n, m));
    }
    // 전체 익은 토마토가 되기 까지 일수 계산
    private static void calcAllRipeDays(
            int[][][] tomatos,
            List<int[]> ripeTomatoPosList,
            int heightSize, int rowSize, int colSize
    ) {
        // 확장 방향 셋팅
        int[] dHeight = {-1, 1, 0, 0, 0, 0};
        int[] dRow = {0, 0, -1, 1, 0, 0};
        int[] dCol = {0, 0, 0, 0, -1, 1};
        // 동시 확장할 시작 익은 토마토 덱에 넣고 visited 셋팅
        Deque<int[]> posDeque = new ArrayDeque<>();
        for (int[] startPos : ripeTomatoPosList) {
            int startHeight = startPos[0];
            int startRow = startPos[1];
            int startCol = startPos[2];
            visited[startHeight][startRow][startCol] = true;
            posDeque.addLast(startPos);
        }
        // 덱이 빌때까지 돌면서 토마토 익히기
        while (!posDeque.isEmpty()) {
            int[] nowPos = posDeque.pollFirst();
            int nowHeight = nowPos[0];
            int nowRow = nowPos[1];
            int nowCol = nowPos[2];
            // 상하 좌우 앞뒤 모두 검사
            for (int i = 0; i < 6; i++) {
                int nextHeight = nowHeight + dHeight[i];
                int nextRow = nowRow + dRow[i];
                int nextCol = nowCol + dCol[i];
                int[] nextPos = { nextHeight, nextRow, nextCol };
                // 포지션 범위 체크 및 방문안한 곳 확인과 익지 않은 토마토인지 확인
                if (isOk(nextPos, heightSize, rowSize, colSize) &&
                        !visited[nextHeight][nextRow][nextCol] &&
                        tomatos[nextHeight][nextRow][nextCol] == 0
                ) {
                    // 방문 처리 및 이전 값에 + 1
                    visited[nextHeight][nextRow][nextCol] = true;
                    tomatos[nextHeight][nextRow][nextCol] = tomatos[nowHeight][nowRow][nowCol] + 1;
                    // 덱에 다음 위치 넣어서 탐색
                    posDeque.addLast(nextPos);
                }
            }
        }
    }
    // 범위 확인 메서드
    private static boolean isOk(int[] pos, int heightSize, int rowSize, int colSize) {
        int height = pos[0];
        int row = pos[1];
        int col = pos[2];
        return (0 <= height && height < heightSize) &&
                (0 <= row && row < rowSize) &&
                (0 <= col && col < colSize);
    }

    // 결과 구하는 메소드
    private static int getAllRipeDays(int[][][] tomatos, int totalHeight, int totalRow, int totalCol) {
        int answer = 0;
        for (int height = 0; height < totalHeight; height++) {
            for (int row = 0; row < totalRow; row++) {
                for (int col = 0; col < totalCol; col++) {
                    int nowDays = tomatos[height][row][col];
                    // 안익은 토마토 있는 경우 -1
                    if (nowDays == 0) {
                        return -1;
                    }
                    // 모든 토마토가 익은 경우 최대 일수 -1이 결과이므로 계산
                    answer = Math.max(answer, nowDays - 1);
                }
            }
        }
        return answer;
    }
}
