import java.io.*;

public class BOJ10770 {
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        // 계산
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char nowCh = line.charAt(i);
            answer.append(changeString(nowCh));
        }
        System.out.println(answer);
    }
    // 문자열 변경
    private static String changeString(char ch) {
        if (isVowel(ch)) return "" + ch;

        char firstCh = getVowel(ch);
        char secondCh = nextChar(ch);
        return "" + ch + firstCh + secondCh;
    }
    // 가가운 모음 찾기
    private static char getVowel(char ch) {
        int minDiff = 100;
        char answer = 'a';
        for (char vo : vowels) {
            int diff = Math.abs(ch - vo);
            if (diff < minDiff) {
                minDiff = diff;
                answer = vo;
            }
        }
        return answer;
    }
    // 모음이 아닌 가까운 문자 찾기
    private static char nextChar(char ch) {
        if (ch == 'z') return ch;

        char next = (char) (ch + 1);
        while (isVowel(next)) {
            next++;
        }
        return next;
    }
    // 모음 확인
    private static boolean isVowel(char ch) {
        for (char v : vowels) {
            if (v == ch) return true;
        }
        return false;
    }
}