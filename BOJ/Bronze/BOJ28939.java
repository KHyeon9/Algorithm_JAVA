import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ28939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int hi = Integer.parseInt(st.nextToken());
            int ki = Integer.parseInt(st.nextToken());

            for (int j = 0; j < ki; j++) {
                int size = Integer.parseInt(st.nextToken());
                if (Math.max(hi, size * m2) > Math.min(hi * k, size * m1)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
