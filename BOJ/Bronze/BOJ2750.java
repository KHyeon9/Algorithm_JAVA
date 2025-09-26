import java.util.Scanner;

public class BOJ2750 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int[] nums = new int[n];
        // 배열에 수 받기
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        // 버블 정렬
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        // 출력
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
