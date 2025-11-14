import java.util.Arrays;
import java.util.Scanner;

public class BOJ34703 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] days = new int[5];

        for (int i = 0; i < n; i++) {
            int idx = sc.nextInt() - 1;
            days[idx]++;
        }
        // 공강이 있는지 확인
        boolean flag = Arrays
                .stream(days)
                .anyMatch(num -> num == 0);

        System.out.println(flag ? "YES" : "NO");
    }
}
