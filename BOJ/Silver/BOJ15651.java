import java.util.*;

public class BOJ15651 {
    static Deque<Integer> nums = new ArrayDeque<>();
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        // 백트레킹 로직 시작
        backtracking(n, m);
        System.out.println(answer);
    }

    private static void backtracking(int length, int checkCnt) {
        // 모은 숫자의 갯수가 뽑아야할 갯수와 같으면 출력
        if (nums.size() == checkCnt){
            printCombi();
            return;
        }
        // 숫자들을 돌면서 조합 찾기
        for (int i = 1; i <= length; i++) {
            // 중복 허용이므로 길이만큼 담기
            nums.add(i);
            backtracking(length, checkCnt);
            nums.pollLast();
        }
    }

    private static void printCombi() {
        StringBuilder sb = new StringBuilder();
        for (int num : nums){
            sb.append(num).append(" ");
        }
        answer.append(sb).append("\n");
    }
}
