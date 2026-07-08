import java.util.*;

public class LeetCode541 {
    // Reverse String II
    public String reverseStr(String s, int k) {
        int len = s.length();
        StringBuilder answer = new StringBuilder();
        /**
         * k 범위 만큼 뒤집는데,
         * k를 뒤집으면 다음 k 범위를 건너뜀
         */
        for (int start = 0; start < len; start += 2 * k) {
            // index 오류를 막기위한 범위 검사
            int reverseEnd = Math.min(start + k, len);
            // 해당 범위 뒤집어 저장
            StringBuilder temp = new StringBuilder(s.substring(start, start + k))
                    .reverse();
            answer.append(temp);
            // 뒤집지 않는 부분 추가
            int remainEnd = Math.min(start + 2 * k, len);
            // 붙일 문자가 남아있으면 붙이기
            if (reverseEnd < remainEnd) {
                answer.append(s, reverseEnd, remainEnd);
            }
        }
        return answer.toString();
    }
}
