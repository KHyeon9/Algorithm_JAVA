import java.util.Scanner;

public class BOJ34934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int now = 0;
        String answer = "";

        for (int i = 0; i < t; i++) {
            String name = sc.next();
            int year = sc.nextInt();

            if (now < year) {
                answer = name;
                now = year;
            }
        }

        System.out.println(answer);
    }
}
