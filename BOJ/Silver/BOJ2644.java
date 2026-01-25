import java.io.*;
import java.util.*;

public class BOJ2644 {
    static ArrayList<ArrayList<Integer>> nodes;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // visited 셋팅
        visited = new boolean[n + 1];
        // 노드 셋팅
        nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }
        // 시작점과 목적지 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            // 부모, 자식 맵핑
            nodes.get(parent).add(child);
            nodes.get(child).add(parent);
        }
        DFS(start, target);
        System.out.println(answer == 0 ? -1 : answer);
    }

    private static boolean DFS(int now, int target) {
        if (now == target) {
            return true;
        }
        visited[now] = true;

        for (int next : nodes.get(now)) {
            if (!visited[next]) {
                answer++;
                if (DFS(next, target)) {
                    return true;
                }
                answer--;
            }
        }
        return false;
    }
}
