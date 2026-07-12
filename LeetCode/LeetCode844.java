public class LeetCode844 {
    // Backspace String Compare
    public boolean backspaceCompare(String s, String t) {
        String sAns = solution(s);
        String tAns = solution(t);
        return sAns.equals(tAns);
    }
    // 문자열 조건을 통한 생성
    private static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            // #이면 이전 글자 삭제
            if (str.charAt(i) == '#') {
                if (!sb.isEmpty()) sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
