import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            String line = sc.next();
            Deque<Character> deque = new ArrayDeque<>();

            for(char ch : line.toCharArray()) {
                // 덱이 비어있으면 push
                if (deque.isEmpty()) {
                    deque.push(ch);
                    continue;
                }
                // ')'가 나왔을때 덱의 마지막 원소가 '('이면 pop
                // 아니면 push
                if (ch == ')' && deque.peek() == '(') {
                    deque.pop();
                } else {
                    deque.push(ch);
                }
            }

            System.out.println(deque.isEmpty() ? "YES" : "NO");
        }
    }
}
