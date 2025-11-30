import java.util.Scanner;

public class BOJ23292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String birthday = sc.next();
        int t = sc.nextInt();
        int maxBio = -1;
        String res = "";

        for (int i = 0; i < t; i++) {
            String codingDay = sc.next();
            int nowBio = calcBio(birthday, codingDay);

            if (nowBio > maxBio) {
                maxBio = nowBio;
                res = codingDay;
            } else if (nowBio == maxBio) {
                if (codingDay.compareTo(res) < 0) {
                    res = codingDay;
                }
            }
        }

        System.out.println(res);
    }

    private static int calcBio(String birthday, String codingDay) {
        int year = 0;
        int month = 0;
        int day = 0;
        int birthChar, codingChar;

        for (int i = 0; i < 4; i++) {
            birthChar = birthday.charAt(i) - '0';
            codingChar = codingDay.charAt(i) - '0';
            year += (int) Math.pow(birthChar - codingChar, 2);
        }

        for (int i = 4; i < 6; i++) {
            birthChar = birthday.charAt(i) - '0';
            codingChar = codingDay.charAt(i) - '0';
            month += (int) Math.pow(birthChar - codingChar, 2);
        }

        for (int i = 6; i < 8; i++) {
            birthChar = birthday.charAt(i) - '0';
            codingChar = codingDay.charAt(i) - '0';
            day += (int) Math.pow(birthChar - codingChar, 2);
        }

        return year * month * day;
    }
}
