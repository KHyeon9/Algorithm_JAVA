public class LeetCode2114 {
    // Maximum Number of Words Found in Sentences
    public int mostWordsFound(String[] sentences) {
        int ans = 0;

        for (String sentence : sentences) {
            ans = Math.max(sentence.split(" ").length, ans);
        }
        return ans;
    }
}

