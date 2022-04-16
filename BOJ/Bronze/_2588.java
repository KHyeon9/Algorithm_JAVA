import java.util.Scanner;

public class _2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        String num2 = sc.next();

        for (int i = 0; i < 3; i++) {
            System.out.println(num * (num2.charAt(2 - i) - '0'));
        }
        System.out.println(num * Integer.parseInt(num2));
    }
}
