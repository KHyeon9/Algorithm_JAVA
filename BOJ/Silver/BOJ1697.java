import java.util.*;
import java.io.*;

public class BOJ1697 {
    static boolean[] visited = new boolean[100001];
    static int[] moveTime = new int[100001];

    public static void main(String[] args) throws Exception{
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subinPos = Integer.parseInt(st.nextToken());
        int sisterPos = Integer.parseInt(st.nextToken());

        // dfs로 최소값 구하기
        bfs(subinPos, sisterPos);
        // 출력
        System.out.println(moveTime[sisterPos]);
    }

    private static void bfs(int pos, int targetPos) {
        // 방문 확인
        visited[pos] = true;
        // 덱에 처음 시작 위치 저장
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(pos);
        // 덱을 돌면서 확인
        while (!deque.isEmpty()) {
            // 현재 포지션 추출
            int nowPos = deque.pollFirst();
            // 가려하는 위치 도착하면 탈출
            if (nowPos == targetPos) {
                return;
            }
            // 다음 포지션들 검사
            int[] nextPositions = {nowPos + 1, nowPos - 1, nowPos * 2};
            for (int i = 0; i < 3; i++) {
                int nextPos =  nextPositions[i];

                // 범위 안이고 방문하지 않았으면 검사
                if (0 <= nextPos && nextPos < 100001 && !visited[nextPos]) {
                    visited[nextPos] = true;
                    moveTime[nextPos] = moveTime[nowPos] + 1;
                    deque.addLast(nextPos);
                }
            }
        }
    }
}
