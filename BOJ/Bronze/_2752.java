import java.util.Arrays;
import java.util.Scanner;

public class _2752 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[3];

        for (int i = 0; i < 3; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        for (int num : nums){
            System.out.print(num + " ");
        }

    }
}
