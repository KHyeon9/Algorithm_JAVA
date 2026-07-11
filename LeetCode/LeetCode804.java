import java.util.HashSet;
import java.util.Set;

public class LeetCode804 {
    // Unique Morse Code Words
    private static final String[] alpaConv = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
            "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
            "..-","...-",".--","-..-","-.--","--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();

        for (String word : words) {
            // 문자열을 주어진 변환값으로 변경 및 저장
            StringBuilder sb = new StringBuilder();
            for (char c :  word.toCharArray()) {
                sb.append(alpaConv[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
