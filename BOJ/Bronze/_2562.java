import java.util.Scanner;

public class _2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[9];
        int max = 0;
        int index = 0;

        for (int i = 0; i < 9; i++) {
            nums[i] = sc.nextInt();
            if (nums[i] > max){
                max = nums[i];
                index = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}
