import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ9506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();

            if (n == -1)
                break;

            List<String> measure = new ArrayList<>();
            int sum = 0;
            for (int m = 1; m <= n / 2; m++) {
                if (n % m == 0){
                    // 약수인 경우 약수 리스트에 추가
                    // sum을 통해 완전수 계산을 위해 +
                    measure.add(String.valueOf(m));
                    sum += m;
                }
            }

            if (sum == n) {
                // 완전수의 경우 문자 생성
                StringBuilder sb = new StringBuilder();
                sb.append(n + " = ")
                        .append(String.join(" + ", measure));
                System.out.println(sb);
            } else {
                // 완전수 아닌 경우 출력
                System.out.println(n + " is NOT perfect.");
            }
        }
    }
}
