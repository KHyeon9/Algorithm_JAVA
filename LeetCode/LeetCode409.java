import java.util.HashMap;
import java.util.Map;

public class LeetCode409 {
    // Longest Palindrome
    public int longestPalindrome(String s) {
        // 문자 출현 횟수 기록
        Map<Character, Integer> charCnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCnt.put(c, charCnt.getOrDefault(c, 0) + 1);
        }

        int res = 0;
        boolean isOdd = false;
        for (char c : charCnt.keySet()) {
            // 홀수든 짝수든 짝수처리하기 위한 수식
            int now = charCnt.get(c);
            res += (now / 2) * 2;
            // 홀수 존재 확인
            if (now % 2 == 1) isOdd = true;
        }
        // 홀수 존재하면 +1
        return isOdd ? res + 1 : res;
    }
}
