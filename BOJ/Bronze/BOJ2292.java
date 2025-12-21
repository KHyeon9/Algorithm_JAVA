import java.util.Scanner;

public class BOJ2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int num) {
        int now = 1;
        int answer = 1;
        // 거리가 중앙에서 1칸 멀어질 수록
        // 둘러야 하는 값이 6의 배수만큼 늘어남
        while (now < num) {
            now += 6 * answer;
            answer++;
        }

        return answer;
    }
}
