import java.util.Scanner;

public class BOJ25304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int n = sc.nextInt();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
            int cnt = sc.nextInt();
            total += price * cnt;
        }

        System.out.println(total == x ? "Yes" : "No");
    }
}
