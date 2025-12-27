import java.io.*;
import java.util.*;

public class BOJ28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int comm = Integer.parseInt(st.nextToken());

            switch (comm) {
                case 1:
                    dq.push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    dq.add(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    System.out.println(dq.isEmpty() ? -1 : dq.pollFirst());
                    break;
                case 4:
                    System.out.println(dq.isEmpty() ? -1 : dq.pollLast());
                    break;
                case 5:
                    System.out.println(dq.size());
                    break;
                case 6:
                    System.out.println(dq.isEmpty() ? 1 : 0);
                    break;
                case 7:
                    System.out.println(dq.isEmpty() ? -1 : dq.peekFirst());
                    break;
                case 8:
                    System.out.println(dq.isEmpty() ? -1 : dq.peekLast());
                    break;
            }
        }
    }
}
