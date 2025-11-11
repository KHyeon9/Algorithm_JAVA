import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int N;
    static int M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 배열 길이 선언
        maze = new int[N][M];
        visited = new boolean[N][M];
        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < M; j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }
        // bfs 메서드 실행
        bfs(0, 0);
        // 출력
        System.out.println(maze[N - 1][M - 1]);
    }

    public static void bfs(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 4; i++) {
                int mx = nx + dx[i];
                int my = ny + dy[i];
                // 미로 크기보다 크면 x
                if (mx >= 0 && my >= 0 && mx < N && my < M) {
                    // 미로의 길이 있으며 방문하지 않은 경우
                    if (maze[mx][my] != 0 && !visited[mx][my]) {
                        visited[mx][my] = true; // 방문 처리
                        maze[mx][my] = maze[nx][ny] + 1; // 이전 값 + 1 (거리 표시)
                        queue.add(new int[]{mx, my}); // 큐에 넣어서 다음 검사에 사용
                    }
                }
            }
        }
    }
}
