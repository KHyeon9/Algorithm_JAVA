import java.io.*;
import java.util.*;

public class BOJ13549 {
    static class Pos {
        int x, time;

        public Pos (int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subinPos = Integer.parseInt(st.nextToken());
        int sisterPos = Integer.parseInt(st.nextToken());

        System.out.println(getMinTime(new Pos(subinPos, 0), sisterPos));
    }

    private static int getMinTime(Pos subinPos, int target) {
        visited[subinPos.x] = true;
        Deque<Pos> posDeq = new ArrayDeque<>();
        posDeq.addLast(subinPos);

        while (!posDeq.isEmpty()) {
            Pos now = posDeq.pollFirst();

            if (now.x == target) {
                return now.time;
            }

            int[] nextList = {now.x * 2, now.x - 1, now.x + 1};
            for (int i = 0; i < 3; i++) {
                int next = nextList[i];
                if (isMove(next) && !visited[next]) {
                    if (i == 0) {
                        posDeq.addFirst(new Pos(next, now.time));
                    } else {
                        posDeq.addLast(new Pos(next, now.time + 1));
                    }
                    visited[next] = true;
                }
            }
        }
        return 0;
    }

    private static boolean isMove(int p) {
        return (0 <= p && p <= 100000);
    }
}
