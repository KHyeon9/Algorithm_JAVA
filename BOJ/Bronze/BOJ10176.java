import java.io.*;

public class BOJ10176 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            String line = br.readLine().toLowerCase();
            // 특수문자 제외
            StringBuilder letters = new StringBuilder();
            for (char ch : line.toCharArray()) {
                if (Character.isLetter(ch)) {
                    letters.append(ch);
                }
            }
            System.out.println(isOpposite(letters.toString()) ? "Yes" : "No");
        }
    }

    private static boolean isOpposite(String line) {
        // 현재 문자열의 알파뱃들 갯수 저장
        int[] alpaCnt = new int[26];
        for (char ch : line.toCharArray()) {
            alpaCnt[ch - 'a']++;
        }
        // 13가지 경우 확인해 대응되는 알파뱃이 맞지 않으면 false
        for (int i = 0; i < 13; i++) {
            if (alpaCnt[i] != alpaCnt[25 - i]) {
                return false;
            }
        }
        return true;
    }
}
