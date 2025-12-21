import java.util.Scanner;

public class BOJ1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int now = 665;
        int cnt = 0;

        while (cnt != n){
            now++;
            if (String.valueOf(now).contains("666")) {
                cnt++;
            }
        }

        System.out.println(now);
    }
}
