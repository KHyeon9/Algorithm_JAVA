public class LeetCode387 {
    // First Unique Character in a String
    public int firstUniqChar(String s) {
        // 알파벳 숫자 세기
        int[] alpa =  new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpa[s.charAt(i) - 'a']++;
        }
        // 가장 먼저 1개만 있는 알파벳 찾기
        for (int i = 0; i < s.length(); i++) {
            if (alpa[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
