import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ17103 {
    static boolean[] primes = new boolean[1000001];
    static {
        Arrays.fill(primes, true);
        primesCalc();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;

            for (int j = 2; j <= n / 2; j++) {
                int gap = n - j;
                // 현재 소수 값이고 n에서 소수값 뺀 결과가 소수인 경우 +1
                if (primes[j] && primes[gap]) {
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    private static void primesCalc() {
        for (int i = 2; i * i < 1000001; i++) {
            for (int j =  i + i; j < 1000001; j += i) {
                if (primes[j]) {
                    primes[j] = false;
                }
            }
        }
    }
}
