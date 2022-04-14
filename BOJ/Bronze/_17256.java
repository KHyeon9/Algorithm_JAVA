import java.util.Scanner;

public class _17256 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ax = scanner.nextInt();
        int ay = scanner.nextInt();
        int az = scanner.nextInt();

        int cx = scanner.nextInt();
        int cy = scanner.nextInt();
        int cz = scanner.nextInt();

        System.out.println(String.format("%d %d %d", cx - az, cy / ay, cz - ax));
    }
}
