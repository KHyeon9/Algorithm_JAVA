import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ15652 {
    static Deque<Integer> nums = new ArrayDeque<>();
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 백트랙킹 시작
        backtracking(0, 1, n, m);

        System.out.println(answer);
    }

    private static void backtracking(
            int depth, int start, int length, int checkCnt
    ) {
        if (depth == checkCnt) {
            answerAppend();
            return;
        }
        // 조합 찾기
        for (int i = start; i <= length; i++) {
            nums.addLast(i);
            // 다음 수를 현재 자기자긴 값 부터 시작하도록 변수 제어
            backtracking(depth + 1, i, length, checkCnt);
            nums.pollLast();
        }
    }
    // answer에 결과값 추가
    private static void answerAppend() {
        for (int num : nums) {
            answer.append(num).append(" ");
        }
        answer.append("\n");
    }
}
