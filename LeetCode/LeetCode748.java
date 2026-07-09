public class LeetCode748 {
    // Shortest Completing Word
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // 소문자 변환 및 알파벳이 아닌값 제거
        String convLicensePlate = licensePlate.toLowerCase()
                .replaceAll("[^a-z]", "");

        int[] alpaCnt = alpaCntCalc(convLicensePlate);
        int minLen = Integer.MAX_VALUE;
        String res = "";
        for (String word : words) {
            int[] nowWordCnt = alpaCntCalc(word);

            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (nowWordCnt[i] < alpaCnt[i]) {
                    flag = false;
                    break;
                }
            }
            // 조건에 맞고 현재 최소 길이보다 작은 경우
            if (flag && minLen > word.length()) {
                res = word;
                minLen = word.length();
            };
        }
        return res;
    }
    // 알파벳 갯수 배열에 저장
    private static int[] alpaCntCalc(String str) {
        int[] alpaCnt = new int[26];
        for (char c : str.toCharArray()) {
            alpaCnt[c - 'a']++;
        }
        return alpaCnt;
    }
}
