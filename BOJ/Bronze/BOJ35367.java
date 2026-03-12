import java.io.*;
import java.util.*;

public class BOJ35367 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rSize = Integer.parseInt(st.nextToken());
        int cSize = Integer.parseInt(st.nextToken());
        // 문자 저장
        char[][] charArr = new char[rSize][cSize];
        for (int r = 0; r < rSize; r++) {
            String row = br.readLine();
            for (int c = 0; c < cSize; c++) {
                charArr[r][c] = row.charAt(c);
            }
        }
        br.close();
        // 문자를 row 먼저 돌며 저장
        StringBuilder answer = new StringBuilder();
        for (int c = 0; c < cSize; c++) {
            for (int r = 0; r < rSize; r++) {
                char now = charArr[r][c];
                if (now != '.') {
                    answer.append(now);
                }
            }
        }
        System.out.println(answer);
    }
}
