import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ15650 {
    static Deque<Integer> nums = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        // 백트랙킹 로직 시작
        backtracking(0, n, m);
    }

    private static void backtracking(int start, int length, int cnt) {
        // 현제 nums의 크기와 필요 갯수가 같다면 출력
        if (nums.size() == cnt) {
            printNums();
            return;
        }
        // visited를 돌면서 false인 경우 nums에 넣고 돌아감
        for (int i = start; i < length; i++) {
            // 현재수 추가
            nums.addLast(i + 1);
            // 백트래킹으로 재귀
            backtracking(i + 1, length, cnt);
            // 현재 수 제거
            nums.pollLast();
        }
    }
    // 출력
    private static void printNums() {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
