import java.util.*;

public class LeetCode500 {
    // Keyboard Row
    static String[] keyboardLines = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    // 문자를 가지고 해당하는 라인을 바로 찾기위한 map
    static Map<Character, Integer> keyboardLineMap = new HashMap<>();
    static {
        for (int i = 0; i < 3; i++) {
            for (char ch : keyboardLines[i].toCharArray()) {
                keyboardLineMap.put(ch, i);
            }
        }
    }
    public String[] findWords(String[] words) {
        // 결과 저장 리스트
        List<String> answer = new ArrayList<>();
        // 탐색
        for (String word : words) {
            // 소문자로 변경후 char 배열로 변환
            char[] lowerWord = word.toLowerCase().toCharArray();
            // 포함되어야 하는 라인 셋팅
            int targetLine = keyboardLineMap.get(lowerWord[0]);
            boolean flag = true;
            // 문자를 돌면서 확인
            for (char ch : lowerWord) {
                // 해당 문자가 포함되어야 하는 라인이 아닌 경우 false 처리 및 탈출
                if (keyboardLineMap.get(ch) != targetLine) {
                    flag = false;
                    break;
                }
            }
            // 문제없는 문자열이면 추가
            if (flag) answer.add(word);
        }
        return answer.toArray(String[]::new);
    }
}
