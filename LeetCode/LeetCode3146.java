public class LeetCode3146 {
    // Permutation Difference between Two Strings
    public int findPermutationDifference(String s, String t) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            ans += Math.abs(i - t.indexOf(s.charAt(i)));
        }
        return ans;
    }
}

