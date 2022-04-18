import java.util.Arrays;
import java.util.Scanner;

public class _1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] socre = new double[n];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            socre[i] = sc.nextDouble();
        }

        Arrays.sort(socre);
        for (double i : socre) {
            sum += i / socre[socre.length-1] * 100;
        }
        System.out.println(sum / n);
    }
}
