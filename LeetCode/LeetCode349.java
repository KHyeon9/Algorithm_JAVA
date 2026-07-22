import java.util.*;

public class LeetCode349 {
    // Intersection of Two Arrays
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> answer =  new ArrayList<>();
        // 찾는 시간 빠르게하기 위한 set
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums2){
            numSet.add(num);
        }
        // 겹치는 숫자 구하기
        for(int num : nums1){
            if(numSet.contains(num)){
                answer.add(num);
                numSet.remove(num);
            }
        }
        // int 배열로 변환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
