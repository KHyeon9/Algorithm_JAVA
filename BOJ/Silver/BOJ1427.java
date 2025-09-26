import java.util.Scanner;

public class BOJ1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int strLength = str.length();
        int[] nums = new int[strLength];
        // 문자열 숫자를 배열에 저장
        for (int i = 0; i < strLength; i++) {
            nums[i] = Integer
                    .parseInt(
                            str.substring(i, i + 1)
                    );
        }
        // 선택 정렬
        for (int i = 0; i < strLength; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < strLength; j++) {
                if (nums[j] > nums[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (nums[maxIdx] > nums[i]) {
                int temp = nums[i];
                nums[i] = nums[maxIdx];
                nums[maxIdx] = temp;
            }
        }
        // 출력
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
