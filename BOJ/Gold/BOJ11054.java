import java.io.*;
import java.util.*;

public class BOJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dpAsc = new int[n];
        // 정방향 LIS
        for (int i = 0; i < n; i++) {
            dpAsc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dpAsc[i] = Math.max(dpAsc[i], dpAsc[j] + 1);
                }
            }
        }
        // 역방향 LIS
        int[] dpDesc = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dpDesc[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dpDesc[i] = Math.max(dpDesc[i], dpDesc[j] + 1);
                }
            }
        }
        // 최대값 계산
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dpAsc[i] + dpDesc[i]);
        }
        // 같은 위치 보므로 1을 빼줘야함
        System.out.println(answer - 1);
    }
}
