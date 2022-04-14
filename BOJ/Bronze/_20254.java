import java.util.Scanner;

public class _20254 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] score = {56, 24, 14, 6};
        int answer = 0;

        for (int i = 0; i < 4; i++){
            int cnt = scanner.nextInt();
            answer += cnt * score[i];
        }

        System.out.println(answer);
    }
}
