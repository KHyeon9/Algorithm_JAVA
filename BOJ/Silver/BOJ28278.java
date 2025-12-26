import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ28278 {
    public static void main(String[] args) throws IOException {
        Deque<String> deque = new ArrayDeque<>();
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            // 입력을 문자열 배열로 변경
            String[] line = br.readLine().split(" ");
            if (line.length == 2) {
                deque.push(line[1]);
            } else {
                if (line[0].equals("2")) {
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.pop());
                    }
                } else if (line[0].equals("3")) {
                    System.out.println(deque.size());
                } else if (line[0].equals("4")) {
                    System.out.println(deque.isEmpty() ? 1 : 0);
                } else {
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.peek());
                    }
                }
            }
        }
    }
}
