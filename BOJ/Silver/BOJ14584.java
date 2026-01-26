import java.io.*;
import java.util.*;

public class BOJ14584 {
    static char[] alpa = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String incodeLine = br.readLine();
        // 변환된 라인을 알파벳 숫자로 작성
        int length = incodeLine.length();
        int[] lineIndex = new int[length];
        for (int i = 0; i < length; i++) {
            lineIndex[i] = incodeLine.charAt(i) - 'a';
        }
        // 주어진 단어 받기
        int cnt = Integer.parseInt(br.readLine());
        String[] words = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            words[i] = br.readLine();
        }
        StringBuilder sb = null;
        for (int i = 0; i < 26; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                sb.append(alpa[(lineIndex[j] + i) % 26]);
            }
            boolean isTrue = false;
            for (int j = 0; j < cnt; j++) {
                if (sb.toString().contains(words[j])) {
                    isTrue = true;
                    break;
                }
            }
            if (isTrue) {
                break;
            }
        }
        System.out.println(sb);
    }
}
