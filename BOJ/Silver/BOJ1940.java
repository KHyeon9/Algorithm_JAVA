import java.util.Arrays;
import java.util.Scanner;

public class BOJ1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N];
        // 고유 번호 입력 받기
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        // 정렬
        Arrays.sort(nums);

        int cnt = 0;
        int start = 0;
        int end = N - 1;

        while (start < end) {
            if (nums[start] + nums[end] < M) {
                start++;
            } else {
                if (nums[start] + nums[end] == M) {
                    cnt++;
                }
                end--;
            }
        }
        System.out.println(cnt);
    }
}
