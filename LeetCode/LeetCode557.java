public class LeetCode557 {
    // Reverse Words in a String III
    public String reverseWords(String s) {
        // " "를 기준으로 분리
        String[] sArr = s.split(" ");
        // StringBuilder로 문자열 뒤집기
        StringBuilder answer = new StringBuilder();
        for (String str : sArr) {
            answer.append(new StringBuilder(str).reverse())
                    .append(" ");
        }
        // 앞, 뒤 빈 " "제거
        return answer.toString().trim();
    }
}
