import java.io.*;
import java.util.*;

public class BOJ30824 {
    // 90이면 충분해서 90까지만 계산
    static long[] fibo = new long[91];
    // 찾기 쉽도록 set
    static Set<Long> fiboSet = new HashSet<>();
    static {
        fibo[1] = 1;
        fibo[2] = 1;
        fiboSet.add(1L);
        for (int i = 3; i <= 90; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
            fiboSet.add(fibo[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            System.out.println(isOk(k, x));
        }
    }
    // 가능한지 확인
    private static String isOk(int k, long x) {
        // k가 3이하로 정해지므로 3개의 경우 따로 계산
        if (k == 1) {
            if (fiboSet.contains(x)) return "YES";
        } else if (k == 2) {
            // 0부터 시작이면 0이 포함되서 제거
            for (int i = 1; i <= 90; i++) {
                if (fiboSet.contains(x - fibo[i])) return "YES";
            }
        } else if (k == 3) {
            // 0부터 시작이면 0이 포함되서 제거
            for (int i = 1; i <= 90; i++) {
                for (int j = 1; j <= 90; j++) {
                    if (fiboSet.contains(x - fibo[i] - fibo[j])) return "YES";
                }
            }
        }
        return "NO";
    }
}
