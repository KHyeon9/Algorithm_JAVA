import java.util.Scanner;

public class BOJ34384 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        int isPassed = time % 3600;
        int remain = 3600 - isPassed;
        int sleepMin = (int) Math.ceil(remain / 60.0);

        System.out.println(sleepMin);
    }
}
