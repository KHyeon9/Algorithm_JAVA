import java.io.*;
import java.util.*;

public class BOJ2667 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> answer = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        // map 초기화
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }
        // bfs 시작
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (map[row][col] == 1) {
                    answer.add(bfs(row, col, n));
                }
            }
        }
        // 오름차순 정렬 및 출력
        answer.sort(Comparator.naturalOrder());
        System.out.println(answer.size());
        for (int cnt : answer) {
            System.out.println(cnt);
        }
    }

    private static int bfs(int row, int col, int size) {
        // 이동 방향 셋팅
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        // 시작점이 1이므로 넓이 1로 시작
        int houseCnt = 1;
        // 방문 처리
        map[row][col] = 0;
        // 덱에 row, col 저장
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[] {row, col});
        // 덱이 빌때까지 돌면서 탐색
        while(!dq.isEmpty()) {
            // 현재 위치 꺼내기
            int[] nowPos = dq.pollFirst();
            int nowRow = nowPos[0], nowCol = nowPos[1];
            for (int i = 0; i < 4; i++) {
                int nextRow = nowRow + dRow[i];
                int nextCol = nowCol + dCol[i];
                // 다음 위치가 집이 있는 경우
                if (isMove(nextRow, nextCol, size) && map[nextRow][nextCol] == 1) {
                    // 방문 처리
                    map[nextRow][nextCol] = 0;
                    // 집수 증가
                    houseCnt++;
                    int[] nextPos = { nextRow, nextCol };
                    dq.add(nextPos);
                }
            }
        }
        return houseCnt;
    }

    private static boolean isMove(int row, int col, int size) {
        // 이동하는 위치가 사이즈의 범위를 벗어나지 않는 경우 true
        return (row >= 0 && row < size) &&
                (col >= 0 && col < size);
    }
}
