import java.io.*;
import java.util.*;

public class BOJ1325 {
    static ArrayList<Integer>[] computerConnect;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int computerCnt = Integer.parseInt(st.nextToken());
        int connectCnt = Integer.parseInt(st.nextToken());
        visited = new int[computerCnt + 1];
        // 연결을 저장할 배열 셋팅
        computerConnect = new ArrayList[computerCnt + 1];
        for (int i = 0; i <= computerCnt; i++) {
            computerConnect[i] = new ArrayList<>();
        }
        // 연결 갯수 만큼 받기
        for (int conn = 0; conn < connectCnt; conn++) {
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            computerConnect[start].add(end);
        }
        int[] computerHackingCnt = new int[computerCnt + 1];
        int maxCnt = -1;
        for (int start = 1; start <= computerCnt; start++) {
            // 연결된 신뢰 컴퓨터 갯수 (해킹 갯수) 구하기
            int nowHackingCnt = getHackingCnt(start);
            // 최대값 저장
            maxCnt = Math.max(maxCnt, nowHackingCnt);
            // 해킹 컴퓨터 갯수 저장
            computerHackingCnt[start] = nowHackingCnt;
        }
        // 최대 갯수인 경우 출력
        StringBuilder answer = new StringBuilder();
        for (int start = 1; start <= computerCnt; start++) {
            if (computerHackingCnt[start] == maxCnt) {
                answer.append(start).append(" ");
            }
        }
        System.out.println(answer);
    }

    private static int getHackingCnt(int start) {
        // 해킹 갯수 저장 변수
        int answer = 0;
        // 초기 셋팅
        visited[start] = start;
        Deque<Integer> deq = new ArrayDeque<>();
        deq.addLast(start);
        // 탐색
        while (!deq.isEmpty()) {
            int now = deq.pollFirst();
            // 다음 값 확인
            for (int next : computerConnect[now]) {
                // 신뢰하는 컴퓨터고 방문하지 않은 경우 탐색 추가
                if (visited[next] != start) {
                    visited[next] = start;
                    deq.addLast(next);
                    answer++;
                }
            }
        }
        return answer;
    }
}
