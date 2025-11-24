import java.util.Scanner;

public class BOJ31432 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("YES");
        System.out.println(nums[1] * 111);
    }
}
