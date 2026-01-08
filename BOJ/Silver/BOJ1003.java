import java.util.Scanner;

public class BOJ1003 {
    static int[] zeroDp = new int[41];
    static int[] oneDp = new int[41];

    static  {
        zeroDp[0] = 1;
        oneDp[1] = 1; oneDp[2] = 2;

        for (int i = 2; i <= 40; i++) {
            zeroDp[i] = zeroDp[i - 2] + zeroDp[i - 1];
            oneDp[i] = oneDp[i - 2] + oneDp[i - 1];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int t = 0; t < testCase; t++) {
            int n = sc.nextInt();
            System.out.println(zeroDp[n] + " " + oneDp[n]);
        }
    }


}
