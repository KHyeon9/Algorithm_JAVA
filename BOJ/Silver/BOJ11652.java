import java.io.*;
import java.util.*;

public class BOJ11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        // map으로 숫자당 총 등장 갯수 저장
        Map<Long, Long> numCnt = new HashMap<>();
        for (int i = 0; i < cnt; i++) {
            long num = Long.parseLong(br.readLine());
            long getCnt = numCnt.getOrDefault(num, 0L) + 1;
            numCnt.put(num, getCnt);
        }
        // 정렬에 사용하기 위한 리스트
        ArrayList<Long> nums = new ArrayList<>(numCnt.keySet());
        nums.sort(((o1, o2) -> {
            // 등장 갯수가 같은 경우 숫자가 작은 것부터
            if (numCnt.get(o2).compareTo(numCnt.get(o1)) == 0) {
                return o1.compareTo(o2);
            }
            // 갯수가 많은순 정렬
            return numCnt.get(o2).compareTo(numCnt.get(o1));
        }));
        System.out.println(nums.get(0));
    }
}
