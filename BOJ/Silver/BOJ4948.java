import java.util.Scanner;

public class BOJ4948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            long n = sc.nextLong();
            if (n == 0) {
                break;
            }

            System.out.println(getPrimeCnt(n));
        }
    }

    private static int getPrimeCnt(long n) {
        int primeCnt = 0;
        // 현제값 초과 2 * 값 이하 검사
        for (long i = n + 1; i <= n * 2; i++) {
            if (isPrime(i)) {
                primeCnt++;
            }
        }
        return primeCnt;
    }
    // 소수 구하기
    private static boolean isPrime(long n) {
        // 2 인경우 true 반환
        if (n == 2) {
            return true;
        }
        // 짝수 제거
        if (n % 2 == 0) {
            return false;
        }
        // 약수 있는지 확인
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
