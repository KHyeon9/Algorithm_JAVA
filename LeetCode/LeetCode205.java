import java.util.*;

public class LeetCode205 {
    // Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
        int strLen = s.length();
        Map<Character, Character> mappingChar = new HashMap<>();
        Set<Character> dupCheck = new HashSet<>();

        for (int i = 0; i < strLen; i++) {
            // 맵핑하지 않은 경우
            if (!mappingChar.containsKey(s.charAt(i))) {
                mappingChar.put(s.charAt(i), t.charAt(i));
                // s의 단어가 매핑은 안되어있지만, t의 단어가 이미 저장됐는지 확인
                if (dupCheck.contains(t.charAt(i))) {
                    return false;
                }
                dupCheck.add(t.charAt(i));
            } else {
                // 매핑이 되어있는데 현제 t의 단어와 다른 경우
                if (mappingChar.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }

            }
        }
        return true;
    }
}
