import java.util.Arrays;
import java.util.Scanner;

public class BOJ9946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = 0;
        while (true) {
            String str1 = sc.next();
            String str2 = sc.next();
            // 탈출 조건
            if (str1.equals("END") && str2.equals("END")) {
                break;
            }
            // 현재 케이스 증가
            testCase++;
            // 문자 배열로 변경
            char[] strChars1 = str1.toCharArray();
            char[] strChars2 = str2.toCharArray();
            // 두 문자 배열 정렬
            Arrays.sort(strChars1);
            Arrays.sort(strChars2);
            // 정렬한 배열 비교하여 값 저장
            String answer = Arrays.equals(strChars1, strChars2) ?
                    "same" : "different";
            // 출력
            System.out.println(String.format("Case %d: %s", testCase, answer));
        }
    }
}
