import java.util.Set;

public class LeetCode3856 {
    // Trim Trailing Vowels
    public String trimTrailingVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!vowels.contains(s.charAt(i))) {
                return s.substring(0, i + 1);
            }
        }
        return "";
    }
}

