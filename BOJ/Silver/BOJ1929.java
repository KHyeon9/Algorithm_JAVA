import java.util.Scanner;

public class BOJ1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] nums = new int[M + 1];
        for (int i = 2; i <= M; i++) {
            nums[i] = i;
        }
        // 소수가 아니면 0으로 변환
        for (int i = 2; i <= Math.sqrt(M); i++) {
            if (nums[i] == 0) continue;
            for (int j = i + i; j <= M; j += i) {
                nums[j] = 0;
            }
        }
        // 출력
        for (int i = N; i <= M; i++) {
            if (nums[i] == 0) continue;
            System.out.println(nums[i]);
        }
    }
}
