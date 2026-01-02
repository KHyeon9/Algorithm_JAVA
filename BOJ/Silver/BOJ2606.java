import java.util.*;
import java.io.*;

public class BOJ2606 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int computerCnt = Integer.parseInt(br.readLine());
        int connectCnt = Integer.parseInt(br.readLine());

        // visited 크기 정의
        visited = new boolean[computerCnt + 1];
        // graph 셋팅
        graph = new ArrayList<>();
        for (int i = 0; i <= computerCnt; i++) {
            graph.add(new ArrayList<>());
        }
        // 연결 입력 받기 {
        for (int i = 0; i < connectCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 양방향 맵핑
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        // dfs 시작
        dfs(1);
        // 출력
        int answer = 0;
        // 1번에게 감염되는 컴퓨터 수므로 2부터 시작
        for (int i = 2; i <= computerCnt; i++) {
            answer += visited[i] ? 1 : 0;
        }
        System.out.println(answer);
    }

    private static void dfs(int node) {
        visited[node] = true;
        // 해당 노드의 다음 노드들 탐색
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
