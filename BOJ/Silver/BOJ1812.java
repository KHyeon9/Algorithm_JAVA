import java.io.*;
import java.util.*;

public class BOJ1812 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // x1 + x2 , x2 + x3 ..... xn + x1이므로
        // 짝수 위치를 빼주면 결국 2x1로 첫번째 수만 남음
        int now = 0;
        int[] sumCandy = new int[n];
        for (int i = 0; i < n; i++) {
            sumCandy[i] = sc.nextInt();
            now += i % 2 == 0 ? sumCandy[i] : -sumCandy[i];
        }
        // 첫번째 캔디 수 구하기
        now /= 2;
        // 첫 갯수를 알았으므로 sumCandy를 돌면서 갯수의 차이 넣기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(now).append("\n");
            // 다음 값으로 변경
            now = sumCandy[i] - now;
        }
        System.out.println(sb);
    }
}
