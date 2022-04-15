import java.util.Scanner;

public class _24183 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] paper = {229 * 324, 297 * 420, 210 * 297};
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        double answer = ((paper[0] * a + paper[1] * b) * 2 + paper[2] * c) * 1e-6;
        System.out.println(String.format("%.6f", answer));

    }
}
