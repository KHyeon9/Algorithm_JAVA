public class LeetCode3838 {
    // Weighted Word Mapping
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            int sum = 0;
            for (char ch : word.toCharArray()) {
                sum += weights[ch - 'a'];
            }
            ans.append((char) (sum % 26 + 'a'));
        }
        return ans.toString();
    }
}
