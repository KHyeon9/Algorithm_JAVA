public class LeetCode1816 {
    // Truncate Sentence
    public String truncateSentence(String s, int k) {
        String[] sArr =  s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(sArr[i]).append(" ");
        }
        return sb.toString().trim();
    }
}

