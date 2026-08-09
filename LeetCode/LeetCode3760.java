import java.util.HashSet;
import java.util.Set;

public class LeetCode3760 {
    // Maximum Substrings With Distinct Start
    public int maxDistinct(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}
