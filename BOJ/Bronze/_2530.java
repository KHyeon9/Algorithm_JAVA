import java.util.Scanner;

public class _2530 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        int time = sc.nextInt();
        int answer = h * 3600 + m * 60 + s + time;

        h = answer / 3600 % 24;
        m = answer % 3600 / 60;
        s = answer % 60;

        System.out.println(h + " " + m + " " + s);
    }
}
