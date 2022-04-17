import java.util.Arrays;
import java.util.Scanner;

public class _2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[8];

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {8, 7, 6, 5, 4, 3, 2, 1};

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        if (Arrays.equals(nums, arr1)){
            System.out.println("ascending");
        } else if (Arrays.equals(nums, arr2)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }
}
