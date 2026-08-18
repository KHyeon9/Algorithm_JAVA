import java.util.HashSet;
import java.util.Set;

public class LeetCode3668 {
    // Restore Finishing Order
    public int[] recoverOrder(int[] order, int[] friends) {
        int[] answer = new int[friends.length];
        Set<Integer> set = new HashSet<>();

        for (int friend : friends) {
            set.add(friend);
        }
        int index = 0;
        for (int num : order) {
            if (set.contains(num)) {
                answer[index++] = num;
            }
        }
        return answer;
    }
}
