import java.util.Scanner;

public class BOJ34802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] start = sc.next().split(":");
        String[] end = sc.next().split(":");
        int t = sc.nextInt();
        int k = sc.nextInt();
        // 시간을 초로 바꾸어 계산하기 위한 배열
        int[] timeRatio = {3600, 60, 1};
        int totalStart = 0;
        int totalEnd = 0;
        // 시작 시간과 끝나는 시간을 초로 변환한 총합
        for (int i = 0; i < 3; i++) {
            totalStart += Integer.parseInt(start[i]) * timeRatio[i];
            totalEnd += Integer.parseInt(end[i]) * timeRatio[i];
        }
        // 달려서 도착할 수 있는 시간
        int moveTime = t * (100 - k) / 100;
        int gap = totalEnd - totalStart;

        System.out.println(gap >= moveTime ? 1 : 0);
    }
}
