import java.io.*;
import java.util.*;

public class BOJ9842 {
    static List<Integer> prime =  new ArrayList<>();
    static {
        // 소수 계산
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        // 0과 1은 소수가 아니므로 제외
        for (int now = 2; now <= 1000000; now++) {
            if (isPrime[now]) {
                prime.add(now);
                for (int noPrime = now + now; noPrime <= 1000000; noPrime += now) {
                    isPrime[noPrime] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 위치 보정 -1
        System.out.println(prime.get(n - 1));
    }
}
