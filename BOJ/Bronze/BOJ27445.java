import java.util.Scanner;

public class BOJ27445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int minY = Integer.MAX_VALUE;
        int yPos = 0;
        // y좌표 계싼
        for (int i = 1; i < N; i++) {
            int y = sc.nextInt();
            if (y < minY) {
                minY = y;
                yPos = i;
            }
        }
        // xy 좌표가 겹치는 부분 처리
        int xy = sc.nextInt();
        if (xy < minY) {
            minY = xy;
            yPos = N;
        }
        // minX시작 값을 겹치는 부분으로 선언
        int minX = xy;
        int xPos = 1;
        // x좌표 계산
        for (int i = 2; i <= M; i++) {
            int x = sc.nextInt();
            if (x < minX) {
                minX = x;
                xPos = i;
            }
        }

        System.out.println(yPos + " " + xPos);
    }
}
