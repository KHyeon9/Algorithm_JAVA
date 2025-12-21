import java.util.Scanner;

public class BOJ11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        while (true) {
            int p = getPrime(num);
            if (p == -1) {
                break;
            }
            System.out.println(p);
            num /= p;
        }
    }
    private static int getPrime(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return -1;
    }
}
