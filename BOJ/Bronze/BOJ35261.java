import java.io.*;
import java.util.*;

public class BOJ35261 {
    static String check = "eagle";
    static int checkLength = check.length();

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        br.close();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= n - checkLength; i++) {
            String now = str.substring(i, i + checkLength);
            // 해당 범위에서 다른 단어의 숫자 세기
            int diffCnt = 0;
            for (int j = 0; j < checkLength; j++) {
                if (now.charAt(j) != check.charAt(j)) {
                    diffCnt++;
                }
            }
            answer = Math.min(answer, diffCnt);
        }
        System.out.println(answer);
    }
}
