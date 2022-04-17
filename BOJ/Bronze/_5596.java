import java.util.Scanner;

public class _5596 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] score1 = new int[4];
        int[] score2 = new int[4];
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < 4; i++) {
            score1[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            score2[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            sum1 += score1[i];
            sum2 += score2[i];
        }


        if (sum1 >= sum2) {
            System.out.println(sum1);
        } else {
            System.out.println(sum2);
        }
    }
}
