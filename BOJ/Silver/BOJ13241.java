import java.io.IOException;
import java.util.Scanner;

public class BOJ13241 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        long b = sc.nextInt();

        System.out.println(lcm(a, b));
        sc.close();
    }
    // 최대 공약수
    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    // 최소 공배수
    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
