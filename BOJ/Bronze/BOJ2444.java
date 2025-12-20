import java.util.Scanner;

public class BOJ2444 {
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            for (int j = 1; j < n + i + 1; j++) {
                if (n - i > j) {
                    sb.append(" ");
                } else {
                    sb.append("*");
                }
            }
            System.out.println(sb);
        }

        for (int i = n - 2; i >= 0; i--) {
            sb = new StringBuilder();
            for (int j = 1; j < n + i + 1; j++) {
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
