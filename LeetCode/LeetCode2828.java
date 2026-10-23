import java.util.List;

public class LeetCode2828 {
    // Check if a String Is an Acronym of Words
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            ans.append(word.charAt(0));
        }
        return ans.toString().equals(s);
    }
}

