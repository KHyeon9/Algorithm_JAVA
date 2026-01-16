import java.io.*;
import java.util.*;

public class BOJ9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int strLength1 = str1.length();
        int strLength2 = str2.length();
        // LIS 알고리즘
        int[][] dp = new int[strLength1 + 1][strLength2 + 1];
        for (int i = 1; i <= strLength1; i++) {
            for (int j = 1; j <= strLength2; j++) {
                int strIdx1 = i - 1;
                int strIdx2 = j - 1;
                if (str1.charAt(strIdx1) == str2.charAt(strIdx2)) {
                    // 문자가 같으면 이전 연속 갯수에 +1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 같지 않으면 양 문자열의 연속 문자 갯수 중에 최대 값 저장
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        // 알고리즘을 통한 문자 찾기
        int dpIdx1 = strLength1, dpIdx2 = strLength2;
        while (dpIdx1 > 0 && dpIdx2 > 0) {
            int strIdx1 = dpIdx1 - 1;
            int strIdx2 = dpIdx2 - 1;
            if (str1.charAt(strIdx1) == str2.charAt(strIdx2)) {
                // 같은 경우 저장하고 둘다 index 감소
                answer.append(str1.charAt(strIdx1));
                dpIdx1--;
                dpIdx2--;
            } else if (dp[dpIdx1 - 1][dpIdx2] >= dp[dpIdx1][dpIdx2 - 1]) {
                // 양 문자열의 연속 갯수를 비교해 큰쪽으로 이동
                dpIdx1--;
            } else {
                dpIdx2--;
            }
        }
        System.out.println(dp[strLength1][strLength2]);
        // 역방향으로 검색하므로 뒤집기
        System.out.println(answer.reverse());
    }
}
