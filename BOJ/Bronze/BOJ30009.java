import java.util.Scanner;

public class BOJ30009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int r = sc.nextInt();
        
        int boundary = 0, in = 0;
        // n번 x축 기준 직선 받기
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (x - r < t && x + r > t) {
                // 원 안에 들어 있는 경우
                in++;
            } else if (x - r == t || x + r == t) {
                // 경계선에 닿아 있는 경우
                boundary++;
            }
        }
        System.out.println(in + " " + boundary);
    }
}
