import java.util.Scanner;

public class BOJ27433 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(facto(n));
    }

    private static long facto(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * facto(n - 1);
    }
}
