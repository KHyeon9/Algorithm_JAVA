import java.util.Scanner;

public class BOJ2720 {
    // 단위 선언
    static int[] money = {25, 10, 5, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int change = sc.nextInt();

            StringBuilder answer = new StringBuilder();
            // 거스름돈 계산
            for (int m : money) {
                answer.append(change / m + " ");
                change %= m;
            }

            System.out.println(answer);
        }
    }
}
