import java.io.*;
import java.util.*;

public class BOJ1753 {
    static class Node {
        int val, weight;

        public Node(int row, int weight) {
            this.val = row;
            this.weight = weight;
        }
    }
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vCnt = Integer.parseInt(st.nextToken());
        int eCnt = Integer.parseInt(st.nextToken());

        int startV = Integer.parseInt(br.readLine());
        // visited
        visited = new int[vCnt + 1];
        for (int i = 1; i <= vCnt ; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        // nodes
        ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
        for (int i = 0; i <= vCnt; i++) {
            nodes.add(new ArrayList<>());
        }
        // 입력 받기
        for (int i = 0; i < eCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // 방향 그래프
            nodes.get(start).add(new Node(end, weight));
        }
        // BFS
        BFS(startV, nodes);
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= vCnt; i++) {
            if (visited[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(visited[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void BFS(int startV, ArrayList<ArrayList<Node>> nodes) {
        // visited 시작점 셋팅
        visited[startV] = 0;
        // 가중치가 낮은 순으로 뽑아야 최저 가중치이므로
        // 우선 순위 큐를 이용
        PriorityQueue<Node> priQueue = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.weight)
        );
        priQueue.add(new Node(startV, 0));
        // 탐색
        while (!priQueue.isEmpty()) {
            Node nowNode = priQueue.poll();
            // 노드들 돌기
            for (Node nextNode : nodes.get(nowNode.val)) {
                // 다음 가중치 계산
                int nextWeight = nowNode.weight + nextNode.weight;
                // 다음 가중치가 저장된 가중치보다 낮은 경우 탐색
                if (visited[nextNode.val] > nextWeight) {
                    // 가중치 설정
                    visited[nextNode.val] = nextWeight;
                    // 다음 가중치와 다음 노드를 객체에 담아 저장
                    priQueue.add(new Node(nextNode.val, nextWeight));
                }
            }
        }
    }
}
