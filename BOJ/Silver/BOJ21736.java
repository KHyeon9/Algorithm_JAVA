import java.io.*;
import java.util.*;

public class BOJ21736 {
    static class PosInfo {
        int row, col;

        public PosInfo (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 크기 받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 컴퍼스 셋팅 및 시작점 찾기
        PosInfo start = new PosInfo(0, 0);
        char[][] campus = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                campus[i][j] = row.charAt(j);
                if (campus[i][j] == 'I') {
                    start = new PosInfo(i, j);
                }
            }
        }
        // visited 셋팅
        visited = new boolean[n][m];
        // BFS로 검사
        int answer = findStudent(start, campus);
        System.out.println(answer == 0 ? "TT" : answer);
    }

    private static int findStudent(
            PosInfo posInfo, char[][] campus
    ) {
        // 크기 저장
        int rowSize = campus.length;
        int colSize = campus[0].length;
        // 이동 방향 셋팅
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        // 시작점 방문 처리 및 덱 설정
        visited[posInfo.row][posInfo.col] = true;
        Deque<PosInfo> deque = new ArrayDeque<>();
        deque.addLast(posInfo);
        // 만난 사람 저장하기 위한 변수
        int answer = 0;
        // 탐색
        while (!deque.isEmpty()) {
            PosInfo now = deque.pollFirst();
            // 사람 만나면 1 증가
            if (campus[now.row][now.col] == 'P') {
                answer++;
            }
            // 4 방향 이동하면서 검사
            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];
                // 벽이거나 범위를 벗어나지 않아 이동 가능 방문하지 않았으면 탐색
                if (
                        canMove(nextRow, nextCol, rowSize, colSize) &&
                        !visited[nextRow][nextCol] &&
                        campus[nextRow][nextCol] != 'X'
                ) {
                    visited[nextRow][nextCol] = true;
                    deque.addLast(new PosInfo(nextRow, nextCol));
                }
            }
        }
        return answer;
    }
    // 이동 가능한 위치인지 확인
    private static boolean canMove(int row, int col, int rowSize, int colSize) {
        return (0 <= row && row < rowSize) &&
                (0 <= col && col < colSize);
    }
}
