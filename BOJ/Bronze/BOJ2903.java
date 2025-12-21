import java.util.Scanner;

public class BOJ2903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 모두 제곱수로 이어나가는데
        // 2, 3, 5, 9로 1 + 2의 n승 만큼 증가한 값의 제곱수임
        // 그래서 한변에 찍히는 점의 갯수는 1 + 2의 n승이고
        int points = (int) Math.pow(2, n) + 1;
        // 이 한변의 값을 제곱하면 값을 출력
        System.out.println(points * points);
    }
}
