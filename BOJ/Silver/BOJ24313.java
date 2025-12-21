import java.util.Scanner;

public class BOJ24313 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int a0 = sc.nextInt();
        int c = sc.nextInt();
        int n0 = sc.nextInt();

        sc.close();

        if (fFunction(a1, a0, n0) <= gFunction(c, n0) && a1 <= c) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static int fFunction(int f1, int f2, int in) {
        return f1 * in + f2;
    }

    private static int gFunction(int g, int in) {
        return g * in;
    }
}
