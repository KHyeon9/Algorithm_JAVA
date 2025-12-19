import java.util.Scanner;

public class BOJ2446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = n; i > 0; i--) {
            printStar(n, i);
        }

        for (int i = 2; i <= n; i++) {
            printStar(n, i);
        }
    }

    private static void printStar(int num, int idx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num + idx - 1; i++) {
            if (num - idx > i) {
                sb.append(" ");
            } else {
                sb.append("*");
            }
        }
        System.out.println(sb);
    }
}
