import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine());
            // 1을 증가하고 소수인지 확인
            while (!isPrime(n)) {
                n++;
            }
            System.out.println(n);
        }
    }
    // 에라토스테네스의 체로 소수인지 확인
    private static boolean isPrime(long num) {
        // 2 미만인 경우
        if (num < 2) {
            return false;
        }
        // 홀수만 찾아서 2는 빠지므로 계산
        if (num == 2) {
            return true;
        }
        // 2를 위에서 판한하므로 이후에 짝수 제외
        if (num % 2 == 0) {
            return false;
        }
        // 홀수만 돌면서 계산
        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
