import java.util.Scanner;

public class BOJ34723 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        int x = sc.nextInt();

        int result = Integer.MAX_VALUE;
        // 최솟값 구하기
        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= c; k++) {
                    result = Math.min(result, Math.abs((i + j) * (j + k) - x));
                }
            }
        }

        System.out.println(result);
        sc.close();
    }
}
