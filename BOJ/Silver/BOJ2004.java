import java.io.*;
import java.util.*;

public class BOJ2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        // 르장드르 공식으로 계산
        // 끝의 0의 갯수를 구하는 거이므로 10으로 나누어지는 갯수를 구해야함
        // 따라서 2와 5의 곱이므로 각각 2와 5로 나눠지는 횟수 중에 작은 값이 10으로 나눠지는 갯수
        long cnt5 = divNumCnt(n, 5) - divNumCnt(m, 5) - divNumCnt((n - m), 5);
        long cnt2 = divNumCnt(n, 2) - divNumCnt(m, 2) - divNumCnt((n - m), 2);

        System.out.println(Math.min(cnt5, cnt2));
        br.close();
    }
    // base에 따라 최대로 나눠질 수있는 횟수 구하기
    private static long divNumCnt (long num, long base) {
        long cnt = 0;
        while (num >= base) {
            num /= base;
            cnt += num;
        }
        return cnt;
    }
}
