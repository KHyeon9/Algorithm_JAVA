import java.util.Scanner;

public class BOJ10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        System.out.println(fibo(n));
    }

    private static long fibo(long n) {
        if (n <= 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}
