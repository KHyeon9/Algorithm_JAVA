import java.util.Scanner;

public class _10797 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int day = sc.nextInt();
        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            int car = sc.nextInt();
            if (car % 10 == day) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
