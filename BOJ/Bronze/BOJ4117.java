import java.io.*;
import java.util.*;

public class BOJ4117 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            int t3 = Integer.parseInt(st.nextToken());
            // 탈출
            if (n == 0 && t1 == 0 && t2 == 0 && t3 == 0) {
                break;
            }
            int answer = 0;
            for (int s = 0; s < n; s++) {
                // t1 계산
                int temp = 2 * n + (s - t1 + n) % n;
                // t2 계산
                temp += n + (t2 - t1 + n) % n;
                // t3 계산
                temp += (t2 - t3 + n) % n;
                answer = Math.max(answer, temp);
            }

            System.out.println(answer);
        }
    }
}
