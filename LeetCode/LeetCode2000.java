public class LeetCode2000 {
    // Reverse Prefix of Word
    public String reversePrefix(String word, char ch) {
        int targetIdx = word.indexOf(ch);
        // 없는 경우 처리
        if (targetIdx == -1) return word;

        String prefix = word.substring(0, targetIdx + 1);
        String suffix = word.substring(targetIdx + 1);
        StringBuilder ans = new StringBuilder(prefix);
        // 뒤집고 나머지 추가
        return  ans.reverse().append(suffix).toString();
    }
}

