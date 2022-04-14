import java.util.Scanner;

public class _18301 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        System.out.println((n1 + 1) * (n2 + 1) / (n3 + 1) - 1);
    }
}
