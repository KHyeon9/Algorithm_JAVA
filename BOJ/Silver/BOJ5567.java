import java.io.*;
import java.util.*;

public class BOJ5567 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // visited 셋팅
        visited = new boolean[n + 1];
        // 리스트 셋팅
        friends = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            friends.add(new ArrayList<Integer>());
        }
        // 리스트 길이
        int len = Integer.parseInt(br.readLine());
        // 친구 관계 저장
        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            friends.get(u).add(v);
            friends.get(v).add(u);
        }
        // 자기자신 방문처리
        visited[1] = true;
        System.out.println(getJoinCnt(1));
    }

    private static int getJoinCnt(int start) {
        visited[start] = true;
        Deque<Integer> deq = new ArrayDeque<>();
        deq.addLast(start);
        int depth = 0, answer = 0;

        while (!deq.isEmpty()) {
            // 친구의 친구인 경우
            if (depth == 2) return answer;
            // 뎁스에 따른 탐색 처리
            int deqSize = deq.size();
            for (int i = 0; i < deqSize; i++) {
                int now = deq.pollFirst();
                for (int next : friends.get(now)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        deq.addLast(next);
                        answer++;
                    }
                }
            }
            depth++;
        }
        return answer;
    }
}
