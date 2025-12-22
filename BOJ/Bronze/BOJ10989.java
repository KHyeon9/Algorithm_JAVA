import java.util.*;
import java.io.*;

public class BOJ10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);
        StringBuilder answer = new StringBuilder();

        for (int num : nums) {
            answer.append(num + "\n");
        }
        System.out.println(answer);
    }
}
