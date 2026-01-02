import java.util.*;
import java.io.*;

public class BOJ24480 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int couunt = 1;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        // visited 및 answer 길이 설정
        visited = new boolean[n + 1];
        answer = new int[n + 1];
        // graph 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 정점들 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 무방향 그래프 이므로 양방향 맵핑
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        // 각 노드들 내림차순 정렬
        for (ArrayList<Integer> nodes : graph) {
            nodes.sort(Comparator.reverseOrder());
        }
        // dfs 시작
        dfs(r);
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int node) {
        // 현재 노드 방문 순서 입력후 순서 증가
        answer[node] = couunt++;
        // 현재 노드 방문 확인
        visited[node] = true;
        // 현재 노드의 다음 노드 탐색
        for (int next : graph.get(node)) {
            // 방문하지 않은 경우만 탐색
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
