import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1707 {
    static ArrayList<Integer>[] graph;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 이분 그래프 flag 초기화
            isEven = true;
            // 배열 초기화
            graph = new ArrayList[v + 1];
            visited = new boolean[v + 1];
            check = new int[v + 1];
            // 그래프 배열의 원소 초기화
            for (int i= 1; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }
            // 입력 받은 노드 추가
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                // 방향이 없으므로 양방향 입력
                graph[start].add(end);
                graph[end].add(start);
            }
            // 노드들 DFS로 탐색
            for (int i = 1; i <= v; i++) {
                // 이분 그래프가 아니면 탈출
                if (!isEven) break;
                DFS(i);
            }
            // 출력
            System.out.println(isEven ? "YES" : "NO");
        }
    }
    // DFS 로직
    public static void DFS(int now) {
        // 방문한 노드면 반환
        if (visited[now]) return;
        // 현재 노드 방문으로 true
        visited[now] = true;
        // 현재 노드와 연결된 노드 탐색
        for (int next : graph[now]) {
            if (!visited[next]) {
                check[next] = check[now] == 0 ? 1 : 0;
                DFS(next);
            } else if (check[now] == check[next]) {
                isEven = false;
            }
        }
    }
}
