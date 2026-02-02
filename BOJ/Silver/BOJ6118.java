import java.io.*;
import java.util.*;

public class BOJ6118 {
    static class BarnInfo {
        int num, dist;
        
        public BarnInfo(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "BarnInfo{" +
                    "num=" + num +
                    ", dist=" + dist +
                    '}';
        }
    }
    static ArrayList<Integer>[] barns;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int barnCnt = Integer.parseInt(st.nextToken());
        int barnConnectCnt = Integer.parseInt(st.nextToken());
        // visited 셋팅
        visited = new boolean[barnCnt + 1];
        // 헛간 셋팅
        barns = new ArrayList[barnCnt + 1];
        for (int i = 1; i <= barnCnt; i++) {
            barns[i] = new ArrayList<>();
        }
        // 헛간 사이 연결된 길 셋팅
        for (int i = 0; i < barnConnectCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            barns[u].add(v);
            barns[v].add(u);
        }
        // 거리 내림차순 번호 오름 차순으로 정렬
        ArrayList<BarnInfo> allBarnInfo = getBarnInfo(1);
        allBarnInfo.sort((o1, o2) -> {
            if (o1.dist == o2.dist) {
                return o1.num - o2.num;
            }
            return o2.dist - o1.dist;
        });
        // 답 저장
        BarnInfo answer = allBarnInfo.get(0);
        // 가장 멀리 있는 헛갓 갯수 구하기
        int maxCnt = 0;
        for (BarnInfo barn : allBarnInfo) {
            if (answer.dist == barn.dist) {
                maxCnt++;
            }
        }
        System.out.println(answer.num + " " + answer.dist + " " + maxCnt);
    }

    private static ArrayList<BarnInfo> getBarnInfo(int start) {
        ArrayList<BarnInfo> answer = new ArrayList<>();
        // 방문 처리 및 덱 셋팅
        visited[start] = true;
        Deque<BarnInfo> deq = new ArrayDeque<>();
        BarnInfo startBarn = new BarnInfo(start, 0);
        deq.addLast(startBarn);

        while (!deq.isEmpty()) {
            BarnInfo now = deq.pollFirst();
            // 다음 헛간 검사
            for (int next : barns[now.num]) {
                // 방문하지 않은 경우
                if (!visited[next]) {
                    visited[next] = true;
                    BarnInfo nextBarn = new BarnInfo(next, now.dist + 1);
                    // 탐색 헛간 거리와 번호 저장
                    answer.add(nextBarn);
                    deq.addLast(nextBarn);
                }
            }
        }
        return answer;
    }
}
