import java.util.Scanner;

public class _2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int hour = (a * 60 + b + c) / 60;
        int min = (a * 60 + b + c) % 60;

        if (hour >= 24) {
            hour -= 24;
        }

        System.out.println(hour + " " + min);
    }
}
