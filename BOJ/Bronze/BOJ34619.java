import java.util.Scanner;

public class BOJ34619 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        // 나눗셈으로 구역 계산 보정을 위한 -1과 +1
        int company = (k - 1) / (b * n) + 1;
        int platoon = (k - 1) % (b * n) / n + 1;
        System.out.println(company + " " + platoon);
    }
}
