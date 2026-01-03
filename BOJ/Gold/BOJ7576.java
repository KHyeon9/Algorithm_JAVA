import java.io.*;
import java.util.*;

public class BOJ7576 {
    static boolean[][] visited;
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        // visited와 tomatoDays 셋팅
        visited = new boolean[n][m];
        int[][] tomatos = new int[n][m];
        // 시적점 저장을 위한 변수
        ArrayList<Integer> startRows = new ArrayList<>();
        ArrayList<Integer> startCols = new ArrayList<>();
        // 토마토 입력 받고 시작점 셋팅
        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; col++) {
                tomatos[row][col] = Integer.parseInt(st.nextToken());
                if (tomatos[row][col] == 1) {
                    startRows.add(row);
                    startCols.add(col);
                }
            }
        }
        // dfs 로직
        dfs(tomatos, startRows, startCols, n, m);
        // 모든 익을 수 있으면 일수 계산
        System.out.println(getTomatoDays(tomatos, n, m));
    }

    private static void dfs(
            int[][] tomatos,
            ArrayList<Integer> startRows,
            ArrayList<Integer> startCols,
            int rowSize,
            int colSize
    ) {
        // 이동 방향 셋팅
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        // 익은 토마드들 방문 체크와 덱 셋팅
        Deque<int[]> posDeque = new ArrayDeque<>();
        for (int i = 0; i < startRows.size(); i++) {
            int startRow = startRows.get(i);
            int startCol = startCols.get(i);
            int[] startPos = { startRow, startCol };
            posDeque.addLast(startPos);
            visited[startRows.get(i)][startCols.get(i)] = true;
        }
        // 덱을 빌때까지 돌면서 확인
        while (!posDeque.isEmpty()) {
            int[] nowPos = posDeque.pollFirst();
            int nowRow = nowPos[0];
            int nowCol = nowPos[1];
            answer = Math.max(answer, tomatos[nowRow][nowCol] - 1);
            // 4방향 확인 후 검사
            for (int i = 0; i < 4; i++) {
                int nextRow = nowRow + dRow[i];
                int nextCol = nowCol + dCol[i];
                // 방문 한했거나 범위 안이거나 익지 않은 경우 탐색
                if (isOk(nextRow, nextCol, rowSize, colSize) &&
                        !visited[nextRow][nextCol] &&
                        tomatos[nextRow][nextCol] == 0) {
                    visited[nextRow][nextCol] = true;
                    tomatos[nextRow][nextCol] = tomatos[nowRow][nowCol] + 1;
                    int[] nextPos = { nextRow, nextCol };
                    posDeque.addLast(nextPos);
                }
            }
        }
    }
    // 범위 확인을 위한 메소드
    private static boolean isOk(int row, int col, int rowSize, int colSize) {
        return (0 <= row && row < rowSize) &&
                (0 <= col && col < colSize);
    }
    // 결과 찾는 로직
    private static int getTomatoDays(int[][] tomatos, int rowSizw, int colSize) {
        int answer = 0;
        for (int row = 0; row < rowSizw; row++) {
            for (int col = 0; col < colSize; col++) {
                int tomatoDays = tomatos[row][col];
                // 익지 않은 토마토가 존재하면 -1
                if (tomatoDays == 0) {
                    return -1;
                }
                // 빈상자가 아닌 경우 최대 일수 구하기
                if (tomatoDays != -1) {
                    answer = Math.max(answer, tomatoDays - 1);
                }
            }
        }
        return answer;
    }
}