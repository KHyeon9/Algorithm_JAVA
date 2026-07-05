import java.util.*;

public class LeetCode290 {
    // Word Pattern
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        // 매칭되는 문자와 문자열이 다른 경우
        if (words.length != pattern.length()) return false;
        // 문자와 문자열을 맵핑할 map과 문자열을 저장했는지 확인할 set
        Map<Character, String> charToString = new HashMap<>();
        Set<String> stringSet = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            char currChar = pattern.charAt(i);
            String currStr = words[i];
            if (charToString.containsKey(currChar)) {
                // 문자가 map에 존재지만 문자열과 저정된 문자열이 다른 경우
                if (!charToString.get(currChar).equals(currStr)) {
                    return false;
                }
            } else {
                // 저장된 문자열이지만, 맵핑된 문자와 다른 경우
                if (stringSet.contains(currStr)) {
                    return false;
                }
                // 맵핑 값 저장 및 문자열 저장
                charToString.put(currChar, currStr);
                stringSet.add(currStr);
            }
        }
        return true;
    }
}
