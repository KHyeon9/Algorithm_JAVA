import java.util.Scanner;

public class _15727 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 0;
        for (int i = 5; i > 0; i--){
            cnt += n / i;
            n %= i;
        }
        System.out.println(cnt);
    }
}
