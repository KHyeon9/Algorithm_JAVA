import java.util.*;

public class LeetCode350 {
    // Intersection of Two Arrays2
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> answer =  new ArrayList<>();
        // 숫자의 갯수 담기
        Map<Integer, Integer> numCnt1 = new HashMap();
        for(int num : nums1){
            numCnt1.put(num, numCnt1.getOrDefault(num, 0) + 1);
        }
        // 계산
        for(int num : nums2){
            // 포함된 수 추가 및 갯수 줄이기
            if (numCnt1.containsKey(num) && numCnt1.get(num) >= 1){
                answer.add(num);
                numCnt1.put(num, numCnt1.get(num) - 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
