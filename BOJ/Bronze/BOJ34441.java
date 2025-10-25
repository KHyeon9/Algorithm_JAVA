import java.util.Scanner;

public class BOJ34441 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String[] time = sc.nextLine().split(":");
        String day = sc.nextLine();
        int weather = Integer.parseInt(sc.nextLine());
        int snow = Integer.parseInt(sc.nextLine());
        int holiday = Integer.parseInt(sc.nextLine());

        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        int total_min = hour * 60 + min;

        // 주말이면 2배
        if (day.equals("sat") || day.equals("sun")) {
            total_min *= 2;
        }
        // 날씨 나쁨이면 2배
        if (weather == 1) {
            total_min *= 2;
        }
        // 눈이 왔으면 3배
        if (snow == 1) {
            total_min *= 3;
        }
        // 공휴일이면 3배
        if (holiday == 1) {
            total_min *= 3;
        }

        System.out.println(String.format("%d:%02d", total_min /60, total_min %60));
    }
}
