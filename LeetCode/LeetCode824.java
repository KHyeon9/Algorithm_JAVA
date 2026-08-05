import java.util.HashSet;
import java.util.Set;

public class LeetCode824 {
    // Goat Latin
    static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        String[] result = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            char first = Character.toLowerCase(words[i].charAt(0));
            // 모음에 포함되면 그대로 아니면 첫글자 뒤로 보내기
            if (vowels.contains(first)) {
                sb.append(words[i]);
            } else {
                sb.append(words[i].substring(1))
                        .append(words[i].charAt(0));
            }
            sb.append("ma").repeat('a', i + 1);
            result[i] = sb.toString();
        }
        
        return String.join(" ",  result);
    }
}
