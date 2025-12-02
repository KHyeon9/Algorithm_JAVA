import java.util.Scanner;

public class BOJ29734 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        int t = sc.nextInt();
        int s = sc.nextInt();

        long zipSleepCnt = (n - 1) / 8;
        long dokSleepCnt = (m - 1) / 8;

        long totalZipTime = n + (zipSleepCnt * s);
        //  처음 독서실 가는 시간 + 공부 시간 + 잘때마다 왕복 시간 + 자는 시간
        long totalDokTime = t + m + dokSleepCnt * (2 * t + s);

        System.out.println(totalZipTime < totalDokTime ?
                "Zip\n" + totalZipTime : "Dok\n" + totalDokTime);
    }
}
