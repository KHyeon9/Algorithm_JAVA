import java.io.*;
import java.util.*;

public class BOJ14503 {
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 로봇 정보 받기
        st = new StringTokenizer(br.readLine());
        int robotRow = Integer.parseInt(st.nextToken());
        int robotCol = Integer.parseInt(st.nextToken());
        int robotDir = Integer.parseInt(st.nextToken());
        // 방 셋팅
        int[][] room = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                room[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // visited
        boolean[][] visited = new boolean[n][m];
        // 청소 시작
        int answer = 0;
        while (true) {
            // 청소하지 않은 부분 청소하기
            if (!visited[robotRow][robotCol]) {
                visited[robotRow][robotCol] = true;
                answer++;
            }

            boolean isMove = false;
            for (int i = 0; i < 4; i++) {
                // 시계 반대로 돌려서 다음 위치 확인
                robotDir = (robotDir + 3) % 4;
                int nextRow = robotRow + dRow[robotDir];
                int nextCol = robotCol + dCol[robotDir];
                // 범위 안이고 청소를 하지 않은 경우
                if (canMove(nextRow, nextCol, n, m) &&
                        !visited[nextRow][nextCol] &&
                        room[nextRow][nextCol] == 0) {
                    // 움직일 수 있음 처리 및 이동
                    isMove = true;
                    robotRow = nextRow;
                    robotCol = nextCol;
                    break;
                }
            }
            // 움직일 수 없는 경우 후진
            if (!isMove) {
                int backRow = robotRow - dRow[robotDir];
                int backCol = robotCol - dCol[robotDir];
                // 후진하면서 벽을 만나거나 범위를 벗어나면 탈출
                if (!canMove(backRow, backCol, n, m) && room[backRow][backCol] == 1) {
                     break;
                }
                // 아니면 후진
                robotRow = backRow;
                robotCol = backCol;
            }
        }
        System.out.println(answer);
    }

    private static boolean canMove(int row, int col, int rowSize, int colSize) {
        return (0 <= row && row < rowSize) && (0 <= col && col < colSize);
    }
}
