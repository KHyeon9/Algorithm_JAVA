import java.util.*;
import java.io.*;

public class BOJ1260 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        // 각 visited 배열 크기 선언
        visited = new boolean[n + 1];
        // graph 셋팅
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // node의 next 셋팅
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 양방향 맵핑
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        // 정점 번호가 적은 것부터이므로 오름차순 정렬
        for (ArrayList<Integer> nexts : graph) {
            nexts.sort(Comparator.naturalOrder());
        }
        // dfs 구하기
        dfs(start);
        // visited와 conter 초기화
        visited = new boolean[n + 1];
        answer.append("\n");
        //bfs 구하기
        bfs(start);
        // 출력
        System.out.println(answer);
    }

    private static void dfs(int node) {
        // 방문 처리 및 순번 저장
        visited[node] = true;
        answer.append(node).append(" ");
        // 노드 탐색
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
    private static void bfs(int node) {
        // 방문 처리 및 순번 저장
        visited[node] = true;
        answer.append(node).append(" ");
        // 덱 생성 및 처음 노드 저장
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(node);
        // 덱이 빌때까지 반복
        while (!dq.isEmpty()) {
            // 현재 노드
            int nowNode = dq.pollFirst();
            // 다음 노드들 탐색
            for (int next : graph.get(nowNode)) {
                if (!visited[next]) {
                    visited[next] = true;
                    answer.append(next).append(" ");
                    dq.addLast(next);
                }
            }
        }
    }
}
