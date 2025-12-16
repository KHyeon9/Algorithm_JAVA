import java.util.Arrays;
import java.util.Scanner;

public class BOJ10384 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().toLowerCase();

            System.out.println(
                    String.format("Case %d: %s", i + 1, getResult(line))
            );
        }
    }

    private static String getResult(String str) {
        int[] alpaCnt = new int[26];
        // 소문자로 변경
        str = str.toLowerCase();
        // 알파벳인 경우에만 갯수 측정
        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                alpaCnt[c - 'a']++;
            }
        }
        // 최소 갯수 구하기
        int minCnt = Arrays.stream(alpaCnt).min().getAsInt();
        // 결과 반환
        if (minCnt == 0) return "Not a pangram";
        if (minCnt == 1) return "Pangram!";
        if (minCnt == 2) return "Double pangram!!";
        return "Triple pangram!!!";
    }
}
