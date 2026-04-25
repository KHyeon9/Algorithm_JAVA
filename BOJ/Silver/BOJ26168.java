import java.io.*;
import java.util.*;

public class BOJ26168 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numsCnt = Integer.parseInt(st.nextToken());
        int commCnt = Integer.parseInt(st.nextToken());
        // 숫자들 저장
        st = new StringTokenizer(br.readLine());
        long[] nums = new long[numsCnt];
        for (int i = 0; i < numsCnt; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(nums);
        // 명령어 받아서 출력
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < commCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int comm = Integer.parseInt(st.nextToken());
            // 명령어 마다 계산
            if (comm == 1) {
                long k = Long.parseLong(st.nextToken());
                answer.append(numsCnt - getLowerCnt(1, nums, k));
            } else if (comm == 2) {
                long k = Long.parseLong(st.nextToken());
                answer.append(numsCnt - getLowerCnt(2, nums, k));
            } else {
                long start = Long.parseLong(st.nextToken());
                long end = Long.parseLong(st.nextToken());
                answer.append(getLowerCnt(2, nums, end) - getLowerCnt(1, nums, start));
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
    // 이분 탐색으로 찾기
    private static long getLowerCnt(int comm, long[] nums, long k) {
        long low = 0, high = nums.length;
        while (low < high) {
            int mid = (int) ((low + high) / 2);
            if (ifCheck(comm, nums[mid], k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean ifCheck(int comm, long num, long k) {
        // 이상인 명령어
        if (comm == 1) {
            return num >= k;
        }
        // 초과인 명령어
        return num > k;
    }
}
