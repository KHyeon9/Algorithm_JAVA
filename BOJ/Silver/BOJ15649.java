import java.io.*;
import java.util.*;

public class BOJ15649 {
    static Deque<Integer> nums = new ArrayDeque<>();
    static StringBuilder answer = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        backtracking(0, n, m);

        System.out.println(answer);
    }

    private static void backtracking(int depth, int length, int checkCnt) {
        // 깊이 (현재 저장 숫자)와 고르는 횟수가 같으면 값 저장
        if (depth == checkCnt) {
            answerAppend();
            return;
        }
        // 최대 수까지 돌면서 값을 저장
        for (int i = 1; i <= length; i++) {
            if (!visited[i]){
                visited[i] = true;
                nums.addLast(i);
                backtracking(depth + 1, length, checkCnt);
                nums.pollLast();
                visited[i] = false;
            }
        }
    }
    // 결과 저장
    private static void answerAppend() {
        for (int num : nums) {
            answer.append(num).append(" ");
        }
        answer.append("\n");
    }
}
