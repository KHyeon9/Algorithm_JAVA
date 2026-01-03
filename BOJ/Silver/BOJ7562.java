import java.io.*;
import java.util.*;

public class BOJ7562 {
    static boolean[][] visited;
    static int[][] minMoveCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int chessSize = Integer.parseInt(br.readLine());
            // 시작 지점
            st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());
            // 목표 지점
            st = new StringTokenizer(br.readLine());
            int targetRow = Integer.parseInt(st.nextToken());
            int targetCol = Integer.parseInt(st.nextToken());
            // visited 셋팅
            visited = new boolean[chessSize][chessSize];
            // minMoveCnt 셋팅
            minMoveCnt = new int[chessSize][chessSize];
            // bfs로 탐색
            bfs(startRow, startCol, targetRow, targetCol, chessSize);
            // 출력
            System.out.println(minMoveCnt[targetRow][targetCol]);
        }
    }

    private static void bfs(int startRow, int startCol, int targetRow, int targetCol, int chessSize) {
        // 나이트가 움직이는 방향 셋팅
        int[] dRow = {-2, -2, -1, 1, 2, 2, -1, 1};
        int[] dCol = {-1, 1, 2, 2, -1, 1, -2, -2};
        // 시작지점 방문 셋팅 및 덱 셋팅
        visited[startRow][startCol] = true;
        Deque<int[]> posDeque = new ArrayDeque<>();
        int[] startPos = {startRow, startCol};
        posDeque.addLast(startPos);
        // 덱을 빌때까지 반복
        while (!posDeque.isEmpty()) {
            // 현재 위치 추출
            int[] nowPos = posDeque.pollFirst();
            int nowRow = nowPos[0];
            int nowCol = nowPos[1];
            // 현재 목표에 도착하면 반환
            if (nowRow == targetRow && nowCol == targetCol) {
                return;
            }
            // 현재 위치에서 나이트의 이동 위치 전부 확인
            for (int i = 0; i < 8; i++) {
                int nextRow = nowRow + dRow[i];
                int nextCol = nowCol + dCol[i];
                // 이동 가능과 방문하지 않으면 확인
                if (isMove(nextRow, nextCol, chessSize) && 
                        !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    minMoveCnt[nextRow][nextCol] = minMoveCnt[nowRow][nowCol] + 1;
                    int[] nextPos = { nextRow, nextCol };
                    posDeque.addLast(nextPos);
                }
            }
        }
    }
    // 이동 가능 체크
    private static boolean isMove(int nextRow, int nextCol, int chessSize) {
        return (0 <= nextRow && nextRow < chessSize) && 
                (0 <= nextCol && nextCol < chessSize);
    }
}
