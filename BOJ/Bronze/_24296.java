import java.util.Scanner;

public class _24296 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 2;
        boolean flag = false;

        while (true) {
            int temp = res;

            while (true) {
                if (temp == n) {
                    flag = true;
                    break;
                }

                if (temp > n) {
                    break;
                }

                temp += temp - 1;
            }

            if (flag) {
                break;
            }

            res++;
        }

        System.out.println(res);
    }
}
