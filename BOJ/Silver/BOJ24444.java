import java.util.*;
import java.io.*;

public class BOJ24444 {
    static boolean[] visited;
    static int[] answer;
    static ArrayList<ArrayList<Integer>> graph;
    static int counter = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        // visited와 answer 배열 크기 셋팅
        // 노드가 1부터 시작하므로 +1
        visited = new boolean[n + 1];
        answer = new int[n + 1];
        // graph 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 정점 u, v 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 무방향 그래프 셋팅
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        // 각 노드의 next들 오름차순 정렬
        for (ArrayList<Integer> nexts : graph) {
            nexts.sort(Comparator.naturalOrder());
        }
        // bfs 시작
        bfs(r);
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int node) {
        // 시작 노드 호출 순서 기입 후 + 1
        answer[node] = counter++;
        // 방문 노드 체크
        visited[node] = true;
        // 덱 생성 및 시작 노드 넣기
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(node);
        // 덱이 비기전까지 반복
        while (!dq.isEmpty()) {
            // 현재 노드 pol;
            int nowNode = dq.pollFirst();
            // 현재 노드의 다음 노드들 탐색
            for (int next : graph.get(nowNode)) {
                // 방문 여부 확인
                if (!visited[next]) {
                    // 방문 체크 및 방문 순서 기입
                    visited[next] = true;
                    answer[next] = counter++;
                    dq.addLast(next);
                }
            }
        }
    }
}
