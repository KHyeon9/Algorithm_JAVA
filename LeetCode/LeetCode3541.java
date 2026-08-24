import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeetCode3541 {
    // Find Most Frequent Vowel and Consonant
    static Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u');
    public int maxFreqSum(String s) {
        Map<Character, Integer> alpaCnt = new HashMap<>();

        for (char c : s.toCharArray()) {
            alpaCnt.put(c, alpaCnt.getOrDefault(c, 0) + 1);
        }

        int maxVowelCnt = 0;
        int maxConsonantCnt = 0;

        for (char c : alpaCnt.keySet()) {
            if (vowel.contains(c)) {
                maxVowelCnt = Math.max(maxVowelCnt, alpaCnt.get(c));
            } else {
                maxConsonantCnt = Math.max(maxConsonantCnt, alpaCnt.get(c));
            }
        }
        return maxVowelCnt + maxConsonantCnt;
    }
}
