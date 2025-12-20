import java.util.*;

public class BOJ2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int b = sc.nextInt();

        System.out.println(convertDecimal(n, b));
    }

    private static int convertDecimal(String num, int base) {
        int answer = 0;
        // 자리수 계산을 위한 값
        int pow = 1;

        for (int i = num.length() - 1; i >= 0; i--) {
            int digit;
            char now = num.charAt(i);
            if (now >= '0' && now <= '9') {
                // 숫자인 경우
                digit = now - '0';
            } else {
                // 영어인 경우
                digit = now - 'A' + 10;
            }
            // 자릿수 계산
            answer += digit * pow;
            // 자릿수 수정
            pow *= base;
        }
        return answer;
    }
}
