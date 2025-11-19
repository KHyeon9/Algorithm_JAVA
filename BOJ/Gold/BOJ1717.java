import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1717 {
    static int[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int testCase = Integer.parseInt(st.nextToken());
        // 노드 초기화
        nodes = new int[nodeNum + 1];
        for (int i = 1; i <= nodeNum; i++) {
            nodes[i] = i;
        }
        // 입력 받기
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int calc = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (calc == 0) {
                union(start, end);
            } else {
                System.out.println(isSame(start, end) ? "YES" : "NO");
            }
        }

    }
    // 유니온 파인드 로직
    private static void union(int start, int end) {
        start = find(start);
        end = find(end);
        nodes[end] = start;
    }
    private static int find(int node) {
        // 자기 자신과 대표 노드가 같은 경우 반환
        if (nodes[node] == node) return node;
        // 다른 경우 대표 노드 찾기 및 빠져 나오면서 값 변경
        return nodes[node] = find(nodes[node]);
    }
    // 두 노드가 같은 집합인지 확인
    private static boolean isSame(int node1, int node2) {
        return find(nodes[node1]) == find(nodes[node2]);
    }
}
