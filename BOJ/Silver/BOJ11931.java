import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ11931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] nums = new Integer[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums, Collections.reverseOrder());
        StringBuilder answer = new StringBuilder();
        for (int num : nums) {
            answer.append(num).append("\n");
        }
        System.out.println(answer);
    }
}
