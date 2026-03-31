import java.io.*;
import java.util.*;

public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] heights = new int[cnt];
        for (int i = 0; i < cnt; i++) {
           heights[i] = Integer.parseInt(st.nextToken());
        }
        // 이전 상태와 비교하기 위해 단조 큐 선언
        Deque<Integer> deq = new ArrayDeque<>();
        // 결과 계산
        int[] answer = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            // 단조 큐가 비어있지 않고 현재 값보다 작은 값 다 제거
            while (!deq.isEmpty() &&
                    heights[deq.peekLast()] < heights[i]) {
                deq.pollLast();
            }
            // 내 이전에 나보다 높은 높이가 존재하면 입력
            if (!deq.isEmpty()) {
                answer[i] = deq.peekLast() + 1;
            }
            // 현재 높이 저장
            deq.addLast(i);
        }
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int n : answer) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
