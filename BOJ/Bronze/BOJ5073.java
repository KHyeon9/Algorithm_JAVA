import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] sticks = new int[3];

            for (int i = 0; i < 3; i ++) {
                sticks[i] = Integer.parseInt(st.nextToken());
            }

            if (Arrays.stream(sticks).sum() == 0) {
                break;
            }

            Arrays.sort(sticks);

            if (sticks[2] >= sticks[0] + sticks[1]) {
                System.out.println("Invalid");
            } else if (sticks[0] == sticks[1] && sticks[1] == sticks[2]) {
                System.out.println("Equilateral ");
            } else if (sticks[0] == sticks[1] || sticks[1] == sticks[2] || sticks[0] == sticks[2]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene ");
            }
        }
    }
}
