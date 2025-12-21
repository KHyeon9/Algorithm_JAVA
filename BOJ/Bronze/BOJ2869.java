import java.util.Scanner;

public class BOJ2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();
        // 다음날 낮이면 도달 가능한 거리 구함
        // 그 값을 하루 이동 거리로 나누고 반올림
        // 다음날 낮에 도달하므로 +1
        int answer = (int) Math.ceil((double) (v - a) / (a - b)) + 1;
        System.out.println(answer);
    }
}