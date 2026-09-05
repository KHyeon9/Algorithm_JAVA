import java.util.Set;

public class LeetCode1684 {
    // Count the Number of Consistent Strings
    public int countConsistentStrings(String allowed, String[] words) {
        Set<String> allowedSet = Set.of(allowed.split(""));
        int ans = 0;

        for (String word : words) {
            int isOk = 1;
            for (String s : word.split("")) {
                if (!allowedSet.contains(s)) {
                    isOk = 0;
                    break;
                }
            }
            ans += isOk;
        }
        return ans;
    }
}

