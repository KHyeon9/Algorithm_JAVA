import java.io.*;
import java.util.*;

public class BOJ2573 {
    static class Pos {
        int row, col;

        public Pos (int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return row == pos.row && col == pos.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
    static int[][] map;
    static boolean[][] visited;
    static int rowSize;
    static int colSize;
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        // 빙산 셋팅
        map = new int[rowSize][colSize];
        Map<Pos, Integer> posHeight = new HashMap<>();
        for (int r = 0; r < rowSize; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < colSize; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                // 빙산 높이 저장
                if (map[r][c] != 0) {
                    posHeight.put(new Pos(r, c), map[r][c]);
                }
            }
        }
        int answer = 0;
        while(true) {
            // 현재 빙산 덩어리 갯수 구하기
            int cnt = 0;
            visited = new boolean[rowSize][colSize];
            for (Pos pos : posHeight.keySet()) {
                if (!visited[pos.row][pos.col]) {
                    cnt++;
                    icebergCheck(pos);
                }
            }
            // 2개 이상이면 탈출
            if (cnt >= 2) {
                break;
            }
            // 다 녹았는데 안되면 탈출
            if (cnt == 0) {
                answer = 0;
                break;
            }
            // 녹은 빙산 구하기
            ArrayList<Pos> meltList = new ArrayList<>();
            for (Pos pos : posHeight.keySet()) {
                // 주변 인접 바다만큼 감소량 구하기
                int meltCnt = 0;
                for (int i = 0; i < 4; i++) {
                    int row = pos.row + dRow[i];
                    int col = pos.col + dCol[i];
                    if (map[row][col] == 0) {
                        meltCnt++;
                    }
                }
                // 해당 빙산의 높이가 녹는 수보다 작으면 삭제
                int nowHeight = posHeight.get(pos);
                if (nowHeight <= meltCnt) {
                    meltList.add(pos);
                } else {
                    // 녹지 않는 다면 높이 감소
                    int changeHeight = nowHeight - meltCnt;
                    posHeight.put(pos, changeHeight);
                    map[pos.row][pos.col] = changeHeight;
                }
            }
            // 한번에 녹이기
            for (Pos meltPos : meltList) {
                posHeight.remove(meltPos);
                map[meltPos.row][meltPos.col] = 0;
            }
            answer++;
        }
        System.out.println(answer);
    }

    private static void icebergCheck(Pos start) {
        // BFS 초기 셋팅
        visited[start.row][start.col] = true;
        Deque<Pos> posDeq = new ArrayDeque<>();
        posDeq.addLast(start);
        // 탐색
        while (!posDeq.isEmpty()) {
            Pos now = posDeq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if (isMove(nextRow, nextCol) && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    posDeq.addLast(new Pos(nextRow, nextCol));
                }
            }
        }
    }

    private static boolean isMove(int row, int col) {
        return (0 <= row && row < rowSize) &&
                (0 <= col && col < colSize) &&
                (map[row][col] != 0);
    }
}
