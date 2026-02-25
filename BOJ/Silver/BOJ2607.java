import java.io.*;
import java.util.*;

public class BOJ2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int wordCnt = Integer.parseInt(br.readLine());
        int[] baseCnt = new int[26];
        String base = br.readLine();
        for (char ch : base.toCharArray()) {
            baseCnt[ch - 'A']++;
        }

        int answer = 0;
        int[] checkCnt = new int[26];
        for (int i = 0; i < wordCnt - 1; i++) {
            String check = br.readLine();
            int lengthGap = Math.abs(check.length() - base.length());
            // 길이가 2개이상 차이나는 경우 불가능
            if (lengthGap >= 2) {
                continue;
            }
            // 0으로 갯수 초기화
            Arrays.fill(checkCnt, 0);
            // 모든 알파벳에 대한 갯수 세기
            for (char ch : check.toCharArray()) {
                checkCnt[ch - 'A']++;
            }
            // 차이 구하기
            int diff = 0;
            for (int j = 0; j < 26; j++) {
                diff += Math.abs(baseCnt[j] - checkCnt[j]);
            }
            // 차이가 1개 이하거나 일이가 같고 1개만 바꾸면 될경우
            // 예시로 diff가 2인 경우 ABC ABD인경우 diff가 2가 됨
            if (diff <= 1 || (diff == 2 && lengthGap == 0)) {
                answer++;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
