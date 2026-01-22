import java.io.*;
import java.util.*;

public class BOJ5427 {
    static class PosInfo {
        int row, col;
        boolean isFire;

        public PosInfo (int row, int col, boolean isFire) {
            this.row = row;
            this.col = col;
            this.isFire = isFire;
        }
    }
    static boolean[][] visited;
    static char[][] map;
    // 이동 방향 선언
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            // 높이와 넓이 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            // visited
            visited = new boolean[h][w];
            // 맵 셋팅 및 불과 상근이 위치 받기
            ArrayList<PosInfo> posList = new ArrayList<>();
            map = new char[h][w];
            for (int r = 0; r < h; r++) {
                String line = br.readLine();
                for (int c = 0; c < w; c++) {
                    map[r][c] = line.charAt(c);
                    if (map[r][c] == '@' || map[r][c] == '*') {
                        posList.add(new PosInfo(r, c, map[r][c] == '*'));
                    }
                }
            }
            int escapeTime = getEscapeTime(posList, h, w);
            System.out.println(escapeTime == -1 ? "IMPOSSIBLE" : escapeTime);
        }
    }

    private static int getEscapeTime(
            ArrayList<PosInfo> posList,
            int rowSize, int colSize
    ) {
        int time = 0;
        // 방문 처리
        Deque<PosInfo> posDeq = new ArrayDeque<>();
        for (PosInfo pos : posList) {
            if (pos.isFire) {
                // 불인 경우 먼저 검사해야 불이 붙으려는 칸 
                // 이동이 불가능함
                posDeq.addFirst(pos);
            } else {
                // 상근이인 경우 방문 처리와 불보다 뒤에 저장
                posDeq.addLast(pos);
                visited[pos.row][pos.col] = true;
            }
        }
        // 탐색
        while (!posDeq.isEmpty()) {
            int cycle = posDeq.size();
            time++;

            for (int c = 0; c < cycle; c++) {
                PosInfo now = posDeq.pollFirst();
                // 탈줄 조건에 맞으며 time 반환
                if (!now.isFire && isEscape(now, rowSize, colSize)) {
                    return time;
                }
                // 상하좌우 탐색
                for (int i = 0; i < 4; i++) {
                    int nextRow = now.row + dRow[i];
                    int nextCol = now.col + dCol[i];
                    // 이동 불가능 경우 확인
                    if (!canMove(nextRow, nextCol, rowSize, colSize)) {
                        continue;
                    }
                    // 빈 공간 확인
                    if (map[nextRow][nextCol] == '.') {
                        // 상근이이고 방문하지 않고 빈 공간인 경우
                        if (!now.isFire &&
                                !visited[nextRow][nextCol]) {
                            visited[nextRow][nextCol] = true;
                            posDeq.addLast(new PosInfo(nextRow, nextCol, false));
                        }
                        // 불인 경우 상하좌우 빈공간 옮겨 붙기
                        if (now.isFire &&
                                map[nextRow][nextCol] != '*') {
                            map[nextRow][nextCol] = '*';
                            posDeq.addLast(new PosInfo(nextRow, nextCol, true));
                        }
                    }
                }
            }

        }
        return -1;
    }
    // 탈출 조건
    private static boolean isEscape(PosInfo pos, int rowSize, int colSize) {
        return (pos.row == 0) ||
                (pos.row == rowSize - 1) ||
                (pos.col == 0) ||
                (pos.col == colSize - 1);
    }
    // 이동 가능 여부
    private static boolean canMove(int row, int col, int rowSize, int colSize) {
        return (0 <= row && row < rowSize) && (0 <= col && col < colSize);
    }
}
