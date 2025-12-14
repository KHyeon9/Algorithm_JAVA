import java.util.Scanner;

public class BOJ3602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int w = sc.nextInt();

        int res = -1;
        int maxSide = (int) Math.sqrt(b + w);

        for (int side = 1; side <= maxSide; side++) {
            int total = (side * side);
            // 총 갯수가 홀수인 경우 1개 차이를 내기 위해 아래처럼 계산
            int maxCnt = (total + 1) / 2;
            int minCnt = total / 2;
            // 각 갯수가 색마다 가지고 있는 갯수마다 작아야함
            if (Math.max(b, w) >= maxCnt && Math.min(b, w) >= minCnt) {
                res = side;
            }
        }

        System.out.println(res == -1 ? "Impossible" : res);
    }
}
