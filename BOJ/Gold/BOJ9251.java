import java.io.*;

public class BOJ9251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        // LCS 알고리즘
        int strLength1 = str1.length();
        int strLength2 = str2.length();
        int[][] dp = new int[strLength1 + 1][strLength2 + 1];
        for (int i = 1; i <= strLength1; i++) {
            for (int j = 1; j <= strLength2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // 일치하면 이전 문자가 연속해서 같은 횟수에 +1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 일치하지 않으면 이전 값과 위에 값중 최대값
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[strLength1][strLength2]);
    }
}