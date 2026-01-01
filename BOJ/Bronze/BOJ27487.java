import java.io.*;
import java.util.*;

public class BOJ27487 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            // nums 초기화
            int[] nums = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }
            // 계산 로직
            int answer = solution(nums, n);
            System.out.println(answer);
        }
    }
    // 1은 곱해도 자기 자신이므로 2만 세서 계산
    private static int solution(int[] nums, int size) {
        // 2 갯수 새기
        int totalTwoCnt = 0;
        for (int num : nums) {
            if (num == 2) totalTwoCnt++;
        }
        // 2의 갯수가 홀수면 반으로 나눌 수 없어서 -1
        if (totalTwoCnt % 2 == 1) return -1;
        // 2의 갯수가 0이면 처음부터 가능하므로 1 반환
        if (totalTwoCnt == 0) return 1;
        // 둘다 아닌 경우 2의 총 갯수의 반절되는 구간을 반환하면 됨
        int twoCnt = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] == 2) {
                twoCnt++;
                if (twoCnt == totalTwoCnt / 2) {
                    return i + 1;
                }
            }
        }
        return -1;
    }
}
