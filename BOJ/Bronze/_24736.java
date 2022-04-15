import java.util.Scanner;

public class _24736 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] point = {6, 3, 2, 1, 2};
        int[] score = {0, 0};

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                score[i] += sc.nextInt() * point[j];
            }
        }

        System.out.println(score[0] + " " + score[1]);
    }
}
