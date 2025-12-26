import java.io.*;
import java.util.*;

public class BOJ4949 {
    static Deque<Character> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            deque = new ArrayDeque<>();
            if (line.equals(".")) {
                break;
            }
            for (char ch : line.toCharArray()) {
                // [], ()의 경우만 적용
                if (ch == '[' || ch == '(') {
                    deque.push(ch);
                } else if (ch == ']' || ch == ')') {
                    if (!deque.isEmpty() && isOk(ch)) {
                        // 비어있으면 오류나기 때문에 제외
                        // 조건에 맞으면 pop
                        deque.pop();
                    } else {
                        // 비어있거나 괄호 조건에 맞지 않는 경우
                        deque.push('x');
                        break;
                    }
                }
            }

            System.out.println(deque.isEmpty() ? "yes" : "no");
        }

    }
    // 덱의 마지막 원소와 들어오는 문자 비교
    private static boolean isOk(char ch) {
        return  (ch == ']' && deque.peek() == '[') ||
                (ch == ')' && deque.peek() == '(');
    }
}
