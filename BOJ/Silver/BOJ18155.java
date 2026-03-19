import java.io.*;
import java.util.*;

public class BOJ18155 {
    static Map<Character, Character> leetspeak = Map.of(
            '0', 'O',
            '1', 'L',
            '2', 'Z',
            '3', 'E',
            '5', 'S',
            '6', 'B',
            '7', 'T',
            '8', 'B'
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 욕설 단어 받기
        String[] badWords = new String[n];
        for (int i = 0; i < n; i++) {
            badWords[i] = br.readLine();
        }
        // 차량 번호판 검사
        for (int i = 0; i < m; i++) {
            String carNumber = br.readLine();
            StringBuilder decode = new StringBuilder();
            for (char ch : carNumber.toCharArray()) {
                if (leetspeak.containsKey(ch)) {
                    decode.append(leetspeak.get(ch));
                } else {
                    decode.append(ch);
                }
            }
            // 욕설 포함 확인
            boolean isValid = true;
            String decodeStr = decode.toString();
            for (String badWord : badWords) {
                if (decodeStr.contains(badWord)) {
                    isValid = false;
                    break;
                }
            }
            System.out.println(isValid ? "VALID" : "INVALID");
        }
    }
}
