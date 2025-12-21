import java.util.Scanner;

public class BOJ19532 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        int temp1 = a * e;
        int temp2 = b * d;

        int x = (c * e - f * b) / (temp1 - temp2);
        int y = (c * d - f * a) / (temp2 - temp1);

        System.out.println(x + " " + y);
    }

}
