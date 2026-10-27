import java.util.*;

public class LeetCode1636 {
    // Sort Array by Increasing Frequency
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> numCnt = new HashMap<>();
        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        for (int num : nums) {
            numCnt.put(num, numCnt.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(boxedNums, (o1, o2) -> {
            int oCnt1 =  numCnt.get(o1);
            int oCnt2 = numCnt.get(o2);

            if (oCnt1 == oCnt2) {
                return o1 - o2;
            }
            return oCnt1 - oCnt2;
        });
        return Arrays.stream(boxedNums).mapToInt(Integer::intValue).toArray();
    }
}

