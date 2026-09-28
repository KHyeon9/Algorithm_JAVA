import java.util.*;

public class LeetCode2418 {
    // Sort the People
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> nameHeightsMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            nameHeightsMap.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        String[] ans = new String[names.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            ans[heights.length - i - 1] = nameHeightsMap.get(heights[i]);

        }

        return ans;
    }
}

