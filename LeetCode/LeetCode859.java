import java.util.*;

public class LeetCode859 {
    // Buddy Strings
    public boolean buddyStrings(String s, String goal) {
        // 두 문자열의 길이 다른 경우
        if (s.length() != goal.length()) return false;
        // 두 문자열이 같은 경우
        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();

            for (char c : s.toCharArray()) {
                if (set.contains(c)) {
                    return true;
                }
                set.add(c);
            }
            return false;
        }
        // 다른 문자인 index 저장
        List<Integer> diffIdx = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffIdx.add(i);
            }
        }
        // 한번 교환이므로 2인 경우만 가능
        if (diffIdx.size() == 2) {
            int idx1 = diffIdx.get(0);
            int idx2 = diffIdx.get(1);
            return s.charAt(idx1) == goal.charAt(idx2)
                    && s.charAt(idx2) == goal.charAt(idx1);
        }
        return false;
    }
}

