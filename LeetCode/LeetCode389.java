import java.util.*;

public class LeetCode389 {
    // Find the Difference
    public char findTheDifference(String s, String t) {
        // 문자의 갯수 담기
        int[] alpaCnt =  new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpaCnt[s.charAt(i) - 'a']++;
        }
        // 다른 문자열의 문자 갯수 빼기
        for (char c : t.toCharArray()) {
            alpaCnt[c - 'a']--;
        }
        // 계산
        for (int i = 0; i < 26; i++) {
            if (alpaCnt[i] != 0) return (char)(i + 'a');
        }
        return 0;
    }
}
