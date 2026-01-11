import java.util.*;
import java.io.*;

public class BOJ24246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int now = nums[0];
        int answer = -1;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= now) {
                answer = i;
                break;
            }
        }
        System.out.println(answer == -1 ? "infinity" : answer);
        br.close();
    }
}
