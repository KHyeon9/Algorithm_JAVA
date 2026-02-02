import java.io.*;
import java.util.*;

public class BOJ14803 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double target = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            double maxTime = 0;

            for (int i = 0; i < cnt; i++) {
                st = new StringTokenizer(br.readLine());
                double ki = Integer.parseInt(st.nextToken());
                double si = Integer.parseInt(st.nextToken());
                // 최대 걸리는 시간 구하기
                double nowTime = (target - ki) / si;
                maxTime = Math.max(maxTime, nowTime);
            }
            // 소수점 6자리 오차까지 구하여 출력
            System.out.printf("Case #%d: %.6f\n", test + 1, target / maxTime);
        }

    }
}
