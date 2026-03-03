import java.io.*;
import java.util.*;

public class BOJ31217 {
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 노트 초기화
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<Integer>());
        }
        // 간선 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes.get(u).add(v);
            nodes.get(v).add(u);
        }
        // 탐색
        long answer = 0;
        for (int i = 1; i <= n; i++) {
            long cnt = nodes.get(i).size();
            answer += (cnt * (cnt - 1) * (cnt - 2) / 6) % MOD;
        }
        System.out.println(answer % MOD);
        br.close();
    }
}
