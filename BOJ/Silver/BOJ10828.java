import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();
            
            if (comm.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                dq.addLast(num);
            } else if (comm.equals("pop")) {
                System.out.println(dq.isEmpty() ? -1 : dq.pollLast());
            } else if (comm.equals("size")) {
                System.out.println(dq.size());
            } else if (comm.equals("empty")) {
                System.out.println(dq.isEmpty() ? 1 : 0);
            } else if (comm.equals("top")) {
                System.out.println(dq.isEmpty() ? -1 : dq.peekLast());
            }
        }
    }
}
