import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15239 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int len = Integer.parseInt(br.readLine());
            String line = br.readLine();
            System.out.println(solution(len, line) ? "valid" : "invalid");
        }
    }

    private static boolean solution(int len, String line) {
        // 길이가 12 보다 작으면 x
        if (len < 12) return false;

        boolean lower = false;
        boolean upper = false;
        boolean digit = false;
        boolean symbol = false;

        for (char c : line.toCharArray()) {
            // 소문자 확인
            if (!lower && Character.isLowerCase(c)) lower = true;
            // 대문자 확인
            if (!upper && Character.isUpperCase(c)) upper = true;
            // 숫자 확인
            if (!digit && Character.isDigit(c)) digit = true;
            // 기호 확인
            if (!symbol && "+_)(*&^%$#@!./,;{}".contains(c + "")) symbol = true;
        }
        return lower && upper && digit && symbol;
    }
}
