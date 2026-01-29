import java.io.*;
import java.util.*;

public class BOJ9466 {
    static boolean[] visited;
    static boolean[] finished;
    static int[] students;
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            int cnt = Integer.parseInt(br.readLine());
            // answer init
            answer = 0;
            // visited, finished init
            visited = new boolean[cnt + 1];
            finished = new boolean[cnt + 1];
            // students setting
            StringTokenizer st = new StringTokenizer(br.readLine());
            students = new int[cnt + 1];
            for (int i = 1; i <= cnt; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }
            // DFS
            for (int i = 1; i <= cnt; i++) {
                if (!visited[i]) {
                    DFS(i);
                }
            }
            System.out.println(cnt - answer);
        }
    }

    private static void DFS(int now) {
        visited[now] = true;
        int next = students[now];
        // 방문하지 않은 경우 탐색
        if (!visited[next]) {
            DFS(next);
        } else if (!finished[next]) {
            // 현재값 +1
            answer++;
            // 방문한 경우 연결된 학생들 세기
            int temp = next;
            while (temp != now) {
                answer++;
                temp = students[temp];
            }
        }
        // 이 노드에서 연결된 다른 노드 탐색 완료 처리
        finished[now] = true;
    }
}
