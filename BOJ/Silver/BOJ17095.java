import java.io.*;
import java.util.*;

public class BOJ17095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        
        int numCnt = Integer.parseInt(br.readLine());
        // 저장 및 최대 최소값 저장
        int maxVal = 0, minVal = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[numCnt];
        for (int i = 0; i < numCnt; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }
        // 최대 최소값의 index가 여러개인 경우 계산을 위한 변수
        int minValIdx = -1;
        int maxValIdx = -1;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < numCnt; i++) {
            // 최대 최소 값일때 인덱스 변경
            if (nums[i] == maxVal) maxValIdx = i;
            if (nums[i] == minVal) minValIdx = i;
            // 2개의 idx가 -1이 아닌 경우 범위 계산
            if (minValIdx != -1 && maxValIdx != -1) {
                int gapIdx = Math.abs(maxValIdx - minValIdx) + 1;
                answer = Math.min(answer, gapIdx);
            }
        }
        System.out.println(answer);
    }
}
