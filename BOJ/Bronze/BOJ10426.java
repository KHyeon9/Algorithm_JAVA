import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ10426 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String date = sc.next();
        int add = sc.nextInt();
        //  년월일 분리
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        // add가 1이면 당일이 기념일이므로 1을 빼서 보정
        add--;
        // 1씩 빼면서 분리
        while (add > 0) {
            day++;
            if (day > monthDays(year, month)) {
                day = 1;
                month++;
                if (month > 12) {
                    month = 1;
                    year++;
                }
            }
            add--;
        }

        System.out.println(String.format("%d-%02d-%02d", year, month, day));
    }

    // 월에 따른 일 수 배열 반환
    static int monthDays(int year, int month) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) return 29;
        return monthDays[month - 1];
    }

    // 윤년 계산
    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
