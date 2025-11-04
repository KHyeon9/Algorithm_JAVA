import java.util.Scanner;

public class BOJ29538 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int a = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int m_i = sc.nextInt();
            m += m_i;
        }
        // 필요 연료가 1톤을 넘어버리면 성립 x
        // F = (M + 사람합 + F) * (α / 1000)
        // 위의 수식의 좌변보다 커져버려 항상 성립 불가함.
        if (a >= 1000) {
            System.out.println("Impossible");
        } else {
            // 아닌경우 비율 추출해서 출력
            double radio = a / 1000.0;
            double fuel = m * radio / (1 - radio);
            System.out.println(fuel);
        }
    }
}
