import java.io.*;
import java.util.*;

public class BOJ20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        // 0과 1의 갯수 구하기
        int[] cnt = new int[2];
        for (char ch : s) {
            cnt[ch - '0']++;
        }
        // 반절 날리기
        cnt[0] = cnt[0] / 2;
        cnt[1] = cnt[1] / 2;
        // 반절의 갯수 만큼 0은 뒤에서 제거해야 사전순 제일앞
        for (int i = s.length - 1; i >= 0; i--) {
            if (cnt[0] > 0 && s[i] == '0') {
                s[i] = '-';
                cnt[0]--;
            }
            if (cnt[0] == 0) {
                break;
            }
        }
        // 반절의 갯수 만큼 1은 앞에서 제거해야 사전순 제일앞
        for (int i = 0; i < s.length; i++) {
            if (cnt[1] > 0 && s[i] == '1') {
                s[i] = '-';
                cnt[1]--;
            }
            if (cnt[1] == 0) {
                break;
            }
        }
        // 지워지지 않은 값을 문자열로 출력
        StringBuilder answer = new StringBuilder();
        for (char ch : s) {
            if (ch != '-') {
                answer.append(ch);
            }
        }
        System.out.println(answer);
        br.close();
    }
}
