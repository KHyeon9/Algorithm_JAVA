import java.util.Scanner;

public class _17496 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int c = scanner.nextInt();
        int p = scanner.nextInt();

        System.out.println((n - 1) / t * c * p);
    }
}
