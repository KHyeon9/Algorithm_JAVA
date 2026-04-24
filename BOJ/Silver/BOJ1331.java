import java.io.*;
import java.util.*;

public class BOJ1331 {
    static class Pos {
        int row, col;

        public Pos(String pos) {
            this.row = pos.charAt(1) - '0';
            this.col = alpaNum.get(pos.charAt(0));
        }
    }

    static Map<Character, Integer> alpaNum = Map.of(
            'A', 1,
            'B', 2,
            'C', 3,
            'D', 4,
            'E', 5,
            'F', 6
    );
    static boolean[][] visited = new boolean[7][7];

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        // 시작점 받기
        Pos start = new Pos(br.readLine());
        Pos now = start;
        visited[now.row][now.col] = true;
        
        boolean isValid = true;
        for (int i = 1; i < 36; i++) {
            Pos next = new Pos(br.readLine());
            // 이동 가능확인 및 방문 확인
            if (!isMove(now, next) || visited[next.row][next.col]) {
                isValid = false;
                continue;
            }
            visited[next.row][next.col] = true;
            now = next;
        }
        // 마지막 시작점인지 확인
        if (!isMove(now, start)) {
            isValid = false;
        }
        System.out.println(isValid ? "Valid" : "Invalid");
    }
    // 이동 가능한지 확인
    private static boolean isMove(Pos now, Pos next) {
        int rowGap = Math.abs(now.row - next.row);
        int colGap = Math.abs(now.col - next.col);
        if (rowGap == 2 && colGap == 1) return true;
        if (rowGap == 1 && colGap == 2) return true;
        return false;
    }
}
