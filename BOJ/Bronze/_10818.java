import java.util.Arrays;
import java.util.Scanner;

public class _10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        System.out.println(nums[0] + " " + nums[n - 1]);
    }
}
