public class LeetCode1528 {
    // Shuffle String
    public String restoreString(String s, int[] indices) {
        String[] ans = new String[s.length()];

        for (int i = 0; i < indices.length; i++) {
            ans[indices[i]] = String.valueOf(s.charAt(i));
        }
        return String.join("", ans);
    }
}

