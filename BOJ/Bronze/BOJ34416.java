import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ34416 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] cups = new boolean[n + 1];
        cups[p] = true;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            boolean temp = cups[num1];
            cups[num1] = cups[num2];
            cups[num2] = temp;
        }
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (cups[i]) {
                idx = i;
                break;
            }
        }
        System.out.println(idx);
    }
}
