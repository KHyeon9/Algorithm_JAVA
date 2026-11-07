public class LeetCode1832 {
    // Check if the Sentence Is Pangram
    public boolean checkIfPangram(String sentence) {
        int[] alpaCnt = new int[26];

        for (int i = 0; i < sentence.length(); i++) {
            alpaCnt[sentence.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (alpaCnt[i] == 0) return false;
        }
        return true;
    }
}

