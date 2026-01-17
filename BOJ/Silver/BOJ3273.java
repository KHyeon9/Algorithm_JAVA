import java.io.*;
import java.util.*;

public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        // 배열 초기화
        int[] nums = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // 타겟
        int target = Integer.parseInt(br.readLine());
        // 쌍의 갯수 구하기
        int answer = 0;
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            // set의 contains는 O(1)이므로 사용
            if (numsSet.contains(target - num)) {
                answer++;
            } else {
                numsSet.add(num);
            }
        }
        System.out.println(answer);
    }
}
