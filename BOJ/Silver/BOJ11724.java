import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11724 {
    static boolean[] visited;
    static List<Integer>[] arr; // 리스트 배열로 선언

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int now, next;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 노드의 수만큼 크기 지정
        visited = new boolean[n + 1];
        arr = new ArrayList[n + 1];
        // 배열 안에 array list 선선
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        // 시작 노드와 이동 가능 노드 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            now = Integer.parseInt(st.nextToken());
            next = Integer.parseInt(st.nextToken());
            // 양방향에 이동 가능 노드 추가
            arr[now].add(next);
            arr[next].add(now);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }
    // dfs 로직
    private static void DFS(int node) {
        // 방문한 노드이면 탐색하지 않음
        if (visited[node]) return;
        // 방문한 노드가 아닌 경우
        visited[node] = true; // 현제 노드 방문값 true
        // 해당 노드와 연결된 다음 노드들 확인
        for (int next : arr[node]) {
            // 만약 방문하지 않았으면 연관된 노드들를 방문하며 내려감
            if (!visited[next]) {
                DFS(next);
            }
        }
    }
}
