import java.io.*;
import java.util.*;

public class BOJ1068 {
    static ArrayList<ArrayList<Integer>> nodes;
    static int answer = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        // visited
        visited = new boolean[cnt];
        // nodes
        nodes = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            nodes.add(new ArrayList<>());
        }
        // parentsList
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] parentsList = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            parentsList[i] = Integer.parseInt(st.nextToken());
        }
        // removeNode
        int removeNode = Integer.parseInt(br.readLine());
        int root = 0;
        for (int i = 0; i < cnt; i++) {
            int parents = parentsList[i];
            // root 저장
            if (parents == -1) {
                root = i;
                continue;
            }
            // 삭제된 노드인 경우나 부모가 삭제된 노드 가리키는 경우 pass
            if (i == removeNode || parents == removeNode) {
                continue;
            }
            nodes.get(parents).add(i);
        }
        if (removeNode == root) {
            System.out.println(0);
        } else {
            DFS(root);
            System.out.println(answer);
        }
    }

    private static void DFS(int nowNode) {
        // 방문 처리
        visited[nowNode] = true;
        // 다음 노드가 없으면 리프 노드
        if (nodes.get(nowNode).isEmpty()) {
            answer++;
            return;
        }
        // 탐색
        for (int next : nodes.get(nowNode)) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }
}
