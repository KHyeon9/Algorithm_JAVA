import java.io.*;
import java.util.*;

public class BOJ4179 {
    static class PosInfo {
        int row, col;
        boolean isFire;

        public PosInfo(int row, int col, boolean isFire) {
            this.row = row;
            this.col = col;
            this.isFire = isFire;
        }
    }
    static int rowSize;
    static int colSize;
    static boolean[][] visited;
    static char[][] miro;
    static int[] dRow = {1, 0, -1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // visited
        visited = new boolean[rowSize][colSize];
        // 미로 셋팅 및 불과 지훈이 위치 받기
        ArrayList<PosInfo> posInfoList = new ArrayList<>();
        miro = new char[rowSize][colSize];
        for (int r = 0; r < rowSize; r++) {
            String line = br.readLine();
            for (int c = 0; c < colSize; c++) {
               miro[r][c] = line.charAt(c);
               // 벽과 빈 공간이 아닌 경우
               if (miro[r][c] != '#' && miro[r][c] != '.') {
                   // 불과 지훈이의 위치를 저장
                   PosInfo posInfo = new PosInfo(
                           r, c, miro[r][c] == 'F'
                   );
                   posInfoList.add(posInfo);
               }
            }
        }
        int escapeTime = getEscapeTime(posInfoList);
        System.out.println(escapeTime == -1 ? "IMPOSSIBLE" : escapeTime);
    }
    // 탈출 시간 구하기
    private static int getEscapeTime(ArrayList<PosInfo> posInfoList) {
        int time = 0;
        // 덱 셋팅 및 visited 셋팅
        Deque<PosInfo> posDeq = new ArrayDeque<>();
        for (PosInfo pos : posInfoList) {
            if (pos.isFire) {
                posDeq.addFirst(pos);
            } else {
                posDeq.addLast(pos);
                visited[pos.row][pos.col] = true;
            }
        }
        // 탐색
        while (!posDeq.isEmpty()) {
            int cycle = posDeq.size();
            time++;
            // 불과 지훈의 이동이 한번에 이동하므로 덱의 사이즈 만큼 반복
            for (int c = 0; c < cycle; c++) {
                PosInfo now = posDeq.pollFirst();
                // 탈출 위치인 경우
                if (!now.isFire && isEscape(now.row, now.col)) {
                    return time;
                }
                for (int i = 0; i < 4; i++) {
                    int nextRow = now.row + dRow[i];
                    int nextCol = now.col + dCol[i];
                    // 움직일 수 있는 경우
                    if (canMove(nextRow, nextCol) && miro[nextRow][nextCol] == '.') {
                        if (now.isFire) {
                            // 불인 경우
                            miro[nextRow][nextCol] = 'F';
                            posDeq.addLast(new PosInfo(nextRow, nextCol, true));
                        } else {
                            if (!visited[nextRow][nextCol]) {
                                visited[nextRow][nextCol] = true;
                                posDeq.addLast(new PosInfo(nextRow, nextCol, false));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isEscape(int row, int col) {
        return  (row == 0 || row == rowSize - 1) ||
                (col == 0 || col == colSize - 1);
    }

    private static boolean canMove(int row, int col) {
        return (0 <= row && row < rowSize) &&
                (0 <= col && col < colSize) &&
                (miro[row][col] != '#' && miro[row][col] != 'F');
    }
}
