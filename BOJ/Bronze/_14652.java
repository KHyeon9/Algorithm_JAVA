import java.util.Scanner;

public class _14652 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(String.format("%d %d", k / m, k % m));
    }
}
