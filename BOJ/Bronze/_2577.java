import java.util.Scanner;

public class _2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] nums = new int[10];
        String mul = Integer.toString(a * b * c);

        for (int i = 0; i < mul.length(); i++){
            int n = mul.charAt(i) - '0';
            nums[n] += 1;
        }

        for (int i: nums){
            System.out.println(i);
        }
    }
}
