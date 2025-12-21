import java.util.Scanner;

public class BOJ2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = -1;

        for (int f = 0; f < n / 5 + 1; f++) {
            for (int t = 0; t < n / 3 + 1; t++) {
                if (f * 5 + t * 3 == n) {
                    answer = f + t;
                    break;
                }
            }
        }

        System.out.println(answer);

    }
}
