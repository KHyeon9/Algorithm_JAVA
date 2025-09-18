import java.util.Scanner;

public class BOJ2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        int start = 0;
        int end = 0;
        int total = 0;
        // 투 포인터로 로직 작성
        while (end <= N) {
             if (total > N) {
                // 현제 구간 합과 n이 작다면 start 빼주고 확장
                total -= start;
                start++;
            } else {
                 // 현제 구간 합과 n이 직가니 같다면 end 확장
                 if (total == N) {
                     // 같으면 cnt + 1
                     cnt++;
                 }
                end++;
                total += end;
            }
        }

        System.out.println(cnt);
    }
}
