import java.util.Scanner;

public class _5575 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            int h1 = sc.nextInt();
            int m1 = sc.nextInt();
            int s1 = sc.nextInt();
            int h2 = sc.nextInt();
            int m2 = sc.nextInt();
            int s2 = sc.nextInt();

            int time1 = h1 * 3600 + m1 * 60 + s1;
            int time2 = h2 * 3600 + m2 * 60 + s2;
            int time = time2 - time1;

            int resultH = time / 3600;
            int resultM = time % 3600 / 60;
            int resultS = time % 60;
            System.out.println(resultH + " " + resultM + " " + resultS);
        }
    }
}
