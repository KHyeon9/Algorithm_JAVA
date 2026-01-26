import java.io.*;
import java.util.*;

public class BOJ9205 {
    static class Pos {
        int row, col;

        public Pos (String line) {
            StringTokenizer st = new StringTokenizer(line);
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            this.row = row;
            this.col = col;
        }
    }
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            int storeCnt = Integer.parseInt(br.readLine());
            visited = new boolean[storeCnt + 2];
            Pos[] map = new Pos[storeCnt + 2];
            // 시작은 집 마지막이 페스티벌
            for (int i = 0; i < storeCnt + 2; i++) {
                map[i] = new Pos(br.readLine());
            }

            System.out.println(isFestivalJoin(map));
        }
    }

    private static String isFestivalJoin(Pos[] map) {
        // 집과 페스티벌 위치 셋팅
        Pos home = map[0];
        Pos festival = map[map.length - 1];
        // 방문 처리와 덱 셋팅
        visited[0] = true;
        Deque<Pos> posDeq = new ArrayDeque<>();
        posDeq.addLast(home);

        while (!posDeq.isEmpty()) {
            Pos now = posDeq.pollFirst();
            // 도착이면 happy
            if (now.row == festival.row && now.col == festival.col) {
                return "happy";
            }
            // 맵 전체 탐색
            for (int i = 1; i < map.length; i++) {
                Pos next = map[i];
                // 거리가 1000이하이고 방문하지 않은 경우 탐색
                if (isMove(now, next) && !visited[i]) {
                    visited[i] = true;
                    posDeq.addLast(next);
                }
            }
        }
        return "sad";
    }
    // 이동 가능한지 확인
    private static boolean isMove(Pos now, Pos next) {
        return (Math.abs(now.row - next.row) + Math.abs(now.col - next.col)) <= 1000;
    }
}
