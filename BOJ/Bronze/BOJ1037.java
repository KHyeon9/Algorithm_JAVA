import java.io.*;
import java.util.*;

public class BOJ1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // 어차피 약수들의 묶음이기 때문에 최소값과 최대값을 곱하면
        // 그 약수들을 가진 가장 작은 값이 나옴
        Arrays.sort(nums);
        System.out.println(nums[0] * nums[nums.length - 1]);
    }
}
