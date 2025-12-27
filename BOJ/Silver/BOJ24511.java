import java.io.*;
import java.util.*;

public class BOJ24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 자료 구조 선택 배열 초기화
        int[] queueOrStack = new int[n];
        for (int i = 0; i < n; i++) {
            queueOrStack[i] = Integer.parseInt(st.nextToken());
        }
        // 초기 자료구조 초기화
        st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            if (queueOrStack[i] == 0) {
                dq.addLast(num);
            }
        }
        // 삽입할 수열 받고 로직 시작
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int nowNum = Integer.parseInt(st.nextToken());
            dq.addFirst(nowNum);
            answer.append(dq.pollLast()).append(" ");
        }
        // 출력
        System.out.println(answer);
    }
}
