import java.io.*;
import java.util.*;

public class BOJ2660 {
    static class MemberInfo {
        int num, dist;

        public MemberInfo(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
    static ArrayList<ArrayList<Integer>> members;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int memberCnt = Integer.parseInt(br.readLine());

        // members 초기화
        members = new ArrayList<>();
        for (int i = 0; i <= memberCnt; i++) {
            members.add(new ArrayList<>());
        }
        // 친구 입력 받기
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 탈출 조건
            if (u == -1 && v == -1) {
                break;
            }
            // members 셋팅
            members.get(u).add(v);
            members.get(v).add(u);
        }
        int[] scores = new int[memberCnt + 1];
        int minScore = Integer.MAX_VALUE;
        for (int i = 1; i <= memberCnt; i++) {
            // visites 초기화
            visited = new boolean[memberCnt + 1];
            scores[i] = getMemberScore(i);
            minScore = Math.min(minScore, scores[i]);
        }
        // 출력
        int candiCnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= memberCnt; i++) {
            if (scores[i] == minScore) {
                candiCnt++;
                sb.append(i).append(" ");
            }
        }
        System.out.println(minScore + " " + candiCnt);
        System.out.println(sb);
    }

    private static int getMemberScore(int start) {
        int answer = 0;
        // 방문 및 덱 셋팅
        visited[start] = true;
        Deque<MemberInfo> memberDeq = new ArrayDeque<>();
        memberDeq.addLast(new MemberInfo(start, 0));
        // 탐색
        while (!memberDeq.isEmpty()) {
            MemberInfo now = memberDeq.pollFirst();
            answer = Math.max(answer, now.dist);

            for (int next : members.get(now.num)) {
                if (!visited[next]) {
                    visited[next] = true;
                    memberDeq.addLast(new MemberInfo(next, now.dist + 1));
                }
            }
        }
        return answer;
    }
}
