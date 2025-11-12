import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ1920 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 수를 찾을 배열 선언 및 담기
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // 정렬
        Arrays.sort(nums);

        // 찾아야 하는 수 및 수들를 담기
        int m = sc.nextInt();
        int[] result = new int[m];
        int[] findNums = new int[m];

        for (int i = 0; i < m; i++) {
            int temp_num = sc.nextInt();
            result[i] = binarySearch(nums, temp_num);
        }

        for (int el : result) {
            System.out.println(el);
        }
    }
    // 이진 탐색으로 값이 존재하는지 확인
    public static int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid = end / 2;

        while (start <= end) {
            if (nums[mid] == target) return 1;
            // 중앙값 확인 및 결과에 따른 값 변경
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return 0;
    }
}
