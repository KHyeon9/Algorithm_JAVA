import java.util.Scanner;

public class BOJ34946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int goStart = sc.nextInt();
        int goEnd = sc.nextInt();
        int walk = sc.nextInt();
        int dist = sc.nextInt();

        int shuttle = goStart + goEnd;

        System.out.println(lateCheck(shuttle, walk, dist));
    }

    private static String lateCheck(
            int shuttleTime,
            int walkTime,
            int limitTime
    ) {
        if (shuttleTime <= limitTime && walkTime <= limitTime) {
            return "~.~";
        } else if (shuttleTime > limitTime && walkTime > limitTime) {
            return "T.T";
        } else if (shuttleTime <= limitTime) {
            return "Shuttle";
        } else {
            return "Walk";
        }
    }
}
