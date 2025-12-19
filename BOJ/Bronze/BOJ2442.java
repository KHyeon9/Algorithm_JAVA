import java.util.Scanner;

public class BOJ2442 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n + i - 1; j++) {
                if (n - i > j) {
                    sb.append(" ");
                } else {
                    sb.append("*");
                }
            }
            System.out.println(sb);
        }
    }
}
