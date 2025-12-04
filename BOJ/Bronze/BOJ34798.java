import java.util.Scanner;

public class BOJ34798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] alarm = sc.next().split(":");
        String[] wakeup = sc.next().split(":");

        int alarmHour = Integer.parseInt(alarm[0]) * 60;
        int alarmMin = Integer.parseInt(alarm[1]);
        int wakeupHour = Integer.parseInt(wakeup[0]) * 60;
        int wakeupMin = Integer.parseInt(wakeup[1]);

        int alarmTotal = alarmHour + alarmMin;
        int wakeupTotal = wakeupHour + wakeupMin;

        System.out.println(alarmTotal <= wakeupTotal ? "YES" : "NO");
    }
}
