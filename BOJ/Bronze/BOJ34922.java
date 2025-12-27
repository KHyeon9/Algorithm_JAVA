import java.util.Scanner;

public class BOJ34922 {
    static double pi = 3.141592;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int r = sc.nextInt();
        // 왼쪽위 꼭지점이므로 원의 넓이 / 4
        double detected = (pi * Math.pow(r, 2)) / 4;
        // 반의 총 넓이
        double total = w * h;
        // 총 넓이에서 감지 넓이 빼주기
        double answer = (total - detected);
        System.out.println(String.format("%.3f", answer));
    }
}
