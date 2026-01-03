import java.util.*;
import java.io.*;

public class BOJ1012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 수
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int nowCount = Integer.parseInt(st.nextToken());
            // 재배지 배열 선언
            int[][] farm = new int[n][m];
            // 배추 심어진 위치 받기
            for (int i = 0; i < nowCount; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[y][x] = 1;
            }
            int warmCount = 0;
            // dfs로 검사
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (farm[row][col] == 1) {
                        // 배추가 연결된 부분 전체 0으로 변경
                        bfs(farm, row, col, n, m);
                        warmCount++;
                    }
                }
            }
            // 출력
            System.out.println(warmCount);
        }
    }

    private static void bfs(int[][] farm, int row, int col, int n, int m) {
        // 시작점 방문 체크
        farm[row][col] = 0;
        // 이동 방향 셋팅
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        // 시작점 배열로 묶기
        int[] start = { row, col };
        // 덱 선언 및 덱에 시작점 넣기
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(start);
        // 덱이 빌때까지 반목
        while (!deque.isEmpty()) {
            int[] nowPosition = deque.pollFirst();
            int nowRow = nowPosition[0];
            int nowCol = nowPosition[1];
            // 상하 좌우를 돌면서 배추가 심어진 곳 확인
            for (int i = 0; i < 4; i++) {
                // 다음 찻을 위치 선언
                int nextRow = nowRow + dRow[i];
                int nextCol = nowCol + dCol[i];
                // 다음 위치에 배추가 심어진 경우
                if (isMove(nextRow, nextCol, n, m) && farm[nextRow][nextCol] == 1) {
                    // 방문 처리
                    farm[nextRow][nextCol] = 0;
                    // 덱에 넣기
                    int[] addPos = { nextRow, nextCol };
                    deque.addLast(addPos);
                }
            }
        }
    }

    private static boolean isMove(
            int nextRow, int nextCol, int rowSize, int colSize
    ) {
        return (0 <= nextRow && nextRow < rowSize) &&
                (0 <= nextCol && nextCol < colSize);
    }
}
