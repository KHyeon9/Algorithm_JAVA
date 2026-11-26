public class LeetCode2278 {
    // Percentage of Letter in String
    public int percentageLetter(String s, char letter) {
        double len = s.length();

        double cnt = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == letter) cnt++;
        }

        return (int) (cnt / len * 100);
    }
}

