import java.io.*;
import java.util.*;

public class BOJ2146 {
    static class PosInfo {
        int row, col, num, dist;

        public PosInfo(int row, int col, int num, int dist) {
            this.row = row;
            this.col = col;
            this.num = num;
            this.dist = dist;
        }
    }
    static int size;
    static int[][] map;
    static boolean[][] changeVisited;
    static boolean[][][] minDistVisited;
    static ArrayList<PosInfo> islandList;
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        // map setting and island pos setting
        map = new int[size][size];
        for (int r = 0; r < size; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < size; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // island PosInfo List init
        islandList = new ArrayList<>();
        // change visited init
        changeVisited = new boolean[size][size];
        // 각 섬마다 다른 숫자로 변경
        int num = 1;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (!changeVisited[r][c] && map[r][c] == 1) {
                    changeIsland(new PosInfo(r, c, num, 0));
                    num++;
                }
            }
        }
        // min dist visited init
        minDistVisited = new boolean[num][size][size];
        // print
        System.out.println(getMinDist(islandList));
    }

    private static int getMinDist(ArrayList<PosInfo> islandList) {
        // deque, visited setting
        Deque<PosInfo> posDeq = new ArrayDeque<>();
        for (PosInfo islandPos : islandList) {
            minDistVisited[islandPos.num][islandPos.row][islandPos.col] = true;
            posDeq.addLast(islandPos);
        }
        // 탐색
        while (!posDeq.isEmpty()) {
            PosInfo now = posDeq.pollFirst();
            // 4 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];
                // 이동 범위 넘어간 경우 다음 탐색
                if (!canMove(nextRow, nextCol)) {
                    continue;
                }
                // 방문하지 않은 경우
                if (!minDistVisited[now.num][nextRow][nextCol] ) {
                    if (map[nextRow][nextCol] == 0) {
                        // 바다인 경우
                        minDistVisited[now.num][nextRow][nextCol] = true;
                        posDeq.addLast(new PosInfo(nextRow, nextCol, now.num, now.dist + 1));
                    } else if (map[nextRow][nextCol] != now.num) {
                        // 다른 섬 도착 경우
                        return now.dist;
                    }

                }
            }
        }

        return -1;
    }

    // 섬마다 다른 번호로 셋팅
    private static void changeIsland(PosInfo start) {
        // 시작점 visited, map 셋팅 및 시작 위치 리스트 저장
        changeVisited[start.row][start.col] = true;
        map[start.row][start.col] = start.num;
        islandList.add(start);
        // deque 셋팅
        Deque<PosInfo> posDeq = new ArrayDeque<>();
        posDeq.addLast(start);
        // 탐색
        while (!posDeq.isEmpty()) {
            PosInfo now = posDeq.pollFirst();
            // 4 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];
                // 범위 넘어가면 다음 위치
                if (!canMove(nextRow, nextCol)) {
                    continue;
                }
                // 방문하지 않고 섬인경우
                if (!changeVisited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                    map[nextRow][nextCol] = start.num;
                    changeVisited[nextRow][nextCol] = true;
                    PosInfo nextPos = new PosInfo(nextRow, nextCol, start.num, 0);
                    posDeq.addLast(nextPos);
                    islandList.add(nextPos);
                }
            }
        }
    }
    // 갈수 있는 위치인지 확인
    private static boolean canMove(int row, int col) {
        return (0 <= row && row < size) &&
                (0 <= col && col < size);
    }
}
