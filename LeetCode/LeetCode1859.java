public class LeetCode1859 {
    // Sorting the Sentence
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] ans = new String[words.length];

        for (String word : words) {
            int len = word.length();
            int idx = word.charAt(len - 1) - 'a' - 1;
            String curStr = word.substring(0, len - 1);
            ans[idx] = curStr;
        }
        return String.join(" ", ans);
    }
}

