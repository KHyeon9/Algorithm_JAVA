import java.util.Scanner;

public class _1297 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt();
        int h = sc.nextInt();
        int w = sc.nextInt();
        double result = d / Math.sqrt((Math.pow(h, 2) + Math.pow(w, 2)));

        System.out.println((int) (result * h) + " " + (int) (result * w));
    }
}
