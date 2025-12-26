import java.util.*;
import java.io.*;

public class BOJ18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();
            if (comm.equals("push")) {
                // push일 경우 add
                queue.offer(Integer.parseInt(st.nextToken()));
            } else {
                if (comm.equals("pop")) {
                    answer.append(queue.isEmpty() ? -1 : queue.poll());
                } else if (comm.equals("size")) {
                    answer.append(queue.size());
                } else if (comm.equals("empty")) {
                    answer.append(queue.isEmpty() ? 1 : 0);
                } else if (comm.equals("front")) {
                    answer.append(queue.isEmpty() ? -1 : queue.getFirst());
                } else if (comm.equals("back")) {
                    answer.append(queue.isEmpty() ? -1 : queue.getLast());
                }
                answer.append("\n");
            }
        }
        System.out.println(answer);
        br.close();
    }
}
