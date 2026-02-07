import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ15815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        Deque<Integer> deq = new ArrayDeque<>();
        for (char ch : line.toCharArray()) {
            if (Character.isDigit(ch)) {
                deq.addLast(ch - '0');
            } else {
                int num1 = deq.pollLast();
                int num2 = deq.pollLast();

                int temp = 0;
                if (ch == '+') {
                    temp = num1 + num2;
                } else if (ch == '-') {
                    temp = num2 - num1;
                } else if (ch == '*') {
                    temp = num1 * num2;
                } else {
                    temp = num2 / num1;
                }
                deq.addLast(temp);
            }
        }
        System.out.println(deq.poll());
    }
}
