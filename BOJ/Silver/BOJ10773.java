import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            // 0이면 pop, 아니면 push
            if (n == 0) {
                deque.pop();
            } else {
              deque.push(n);
            }
        }
        // 내부에 남은 수 총합 구하기
        int answer = 0;
        for (int n : deque) {
            answer += n;
        }
        System.out.println(answer);
    }
}
