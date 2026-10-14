public class LeetCode1662 {
    // Check If Two String Arrays are Equivalent
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String word : word1) {
            sb1.append(word);
        }

        for (String word : word2) {
            sb2.append(word);
        }

        return sb1.toString().contentEquals(sb2);
    }
}

