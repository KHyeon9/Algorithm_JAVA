import java.io.*;
import java.util.*;

public class BOJ1759 {
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static char[] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        chars = new char[cnt];
        for (int i = 0; i < cnt; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);

        DFS(0, len, new StringBuilder());
    }

    private static void DFS(int start, int len, StringBuilder sb) {
        // 길이가 주어진 값과 같고 조건에 맞으면 값 출력
        if (sb.length() == len) {
            if (isOk(sb)) {
                System.out.println(sb);
            }
            return;
        }

        for (int i = start; i < chars.length; i++) {
            sb.append(chars[i]);
            DFS(i + 1, len, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    // 모듬 1개 이상 자음 2개 이상인지 확인
    private static boolean isOk(StringBuilder sb) {
        int vowelCnt = 0;
        for (char vowel : vowels) {
            for (char ch : sb.toString().toCharArray()) {
                vowelCnt += vowel == ch ? 1 : 0;
            }
        }
        return (vowelCnt >= 1) && (sb.length() - vowelCnt >= 2);
    }
}
