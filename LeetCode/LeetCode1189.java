import java.util.*;

public class LeetCode1189 {
    static final String str = "balloon";

    // Maximum Number of Balloons
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> charCntMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            charCntMap.put(c, charCntMap.getOrDefault(c, 0) + 1);
        }

        int answer = 10001;
        for (char c : str.toCharArray()) {
            // 2개 필요한 단어 계산을 위한 div
            int div = c == 'l' || c == 'o' ? 2 : 1;
            answer = Math.min(
                    answer, charCntMap.getOrDefault(c, 0) / div);
        }
        return answer;
    }
}
