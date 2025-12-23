import java.util.Scanner;

public class BOJ34921 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int t = sc.nextInt();
        int answer = 10 + 2 * (25 - a + t);

        System.out.println(Math.max(answer, 0));
    }
}
