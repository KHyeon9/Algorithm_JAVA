import java.util.Arrays;
import java.util.Scanner;

public class BOJ14215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sticks = new int[3];

        for (int i = 0; i < 3; i++) {
            sticks[i] = sc.nextInt();
        }

        Arrays.sort(sticks);

        int ramainStickLen = sticks[0] + sticks[1];
        int tallStick = Math.min(ramainStickLen - 1, sticks[2]);

        System.out.println(ramainStickLen + tallStick);
    }
}
