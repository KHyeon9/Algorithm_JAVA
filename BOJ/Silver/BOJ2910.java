import java.io.*;
import java.util.*;

public class BOJ2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        int maxNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 메모리 관리를 위한 map 셋팅 (입력이 1000개로 한정되므로)
        Map<Integer, Integer> numMinIdx = new HashMap<>();
        Map<Integer, Integer> numCnt = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = Integer.parseInt(st.nextToken());
            int saveIndex = numMinIdx.getOrDefault(num, Integer.MAX_VALUE);
            numMinIdx.put(num, Math.min(saveIndex, i));
            numCnt.put(num, numCnt.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> nums = new ArrayList<>(numCnt.keySet());
        // 정렬
        nums.sort(((o1, o2) -> {
            // 갯수가 많으면 앞으로
            if (numCnt.get(o1) != numCnt.get(o2)) {
                return numCnt.get(o2) - numCnt.get(o1);
            }
            // 갯수가 같은 경우 index가 작으면 앞으로
            return numMinIdx.get(o1) - numMinIdx.get(o2);
        }));
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            int loop = numCnt.get(num);
            // 출현 횟수에 따른 저장
            for (int i = 0; i < loop; i++) {
                sb.append(num).append(" ");
            }
        }
        System.out.println(sb);
    }
}
