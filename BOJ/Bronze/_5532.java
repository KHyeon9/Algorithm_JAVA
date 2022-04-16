import java.util.Scanner;

public class _5532 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        double b = sc.nextDouble();
        double a = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();

        double result = l - Math.max(Math.ceil(b / c), Math.ceil(a / d));
        System.out.println((int) result);
    }
}
