import java.io.*;
import java.util.*;

public class BOJ2548 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // 작은수 찾기 위한 정렬
        Arrays.sort(nums);
        // 차이의 합과 최소 차이 합을 구함
        int[] gapArr = new int[cnt];
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < cnt; i++) {
            int gapSum = 0;
            for (int j = 0; j < cnt; j++) {
                if (i == j) continue;
                gapSum += Math.abs(nums[i] - nums[j]);
            }
            minGap = Math.min(minGap, gapSum);
            gapArr[i] = gapSum;
        }
        // 최소 차이합의 인덱스 찾기
        int answerIdx = 0;
        for (int i = 0; i < cnt; i++) {
            if (minGap == gapArr[i]) {
                answerIdx = i;
                break;
            }
        }
        System.out.println(nums[answerIdx]);
        br.close();
    }
}
