import java.util.Scanner;

public class BOJ34823 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            int cnt = sc.nextInt();
            cnt /= i == 1 ? 2 : 1;
            res = Math.min(res, cnt);
        }

        System.out.println(res);
    }
}
