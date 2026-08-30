import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode3289 {
    // The Two Sneaky Numbers of Digitville
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> numsCnt = new HashMap<>();
        int[] answer = new int[2];
        int idx = 0;
        for (int num : nums) {
            numsCnt.put(num, numsCnt.getOrDefault(num, 0) + 1);
            if (numsCnt.get(num) > 1) {
                answer[idx++] = num;
            }
            if (idx > 1) break;
        }
        Arrays.sort(answer);
        return answer;
    }
}

