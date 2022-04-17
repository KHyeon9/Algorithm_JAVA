import java.util.Scanner;

public class _11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String num = sc.next();
        int result = 0;

        for (int i = 0; i < num.length(); i++) {
           result += (int) num.charAt(i) - '0';
        }

        System.out.println(result);
    }
}
