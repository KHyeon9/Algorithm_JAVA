import java.util.ArrayList;
import java.util.List;

public class LeetCode2942 {
    // Find Words Containing Character
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        String xStr = String.valueOf(x);
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(xStr)) {
                res.add(i);
            }
        }
        return res;
    }
}
