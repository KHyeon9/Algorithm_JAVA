import java.util.Scanner;

public class BOJ33488 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            // 순서대로 수열을 사용하면 소수 위치와 소수의 값 차가 같아서
            // 항상 아름다운 수열이 존재함
            System.out.println("YES");
            for (int j = 1; j <= n; j++) {
                System.out.print(j + " ");
            }
        }
    }
}
