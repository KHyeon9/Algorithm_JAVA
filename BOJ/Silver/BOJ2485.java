import java.util.Scanner;

public class BOJ2485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] nums = new int[t];

        for (int i = 0; i < t; i++) {
            nums[i] = sc.nextInt();
        }
        // 가로수 사이 거리들의 최대 공약수 구하기
        int gcd = nums[1] - nums[0];
        for (int i = 2; i < t; i++) {
            gcd = getGcd(gcd, nums[i] - nums[i - 1]);
        }

        int start = nums[0];
        int end = nums[t - 1];

        System.out.println((end - start) / gcd - t + 1);
    }

    private static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }
}
