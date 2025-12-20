import java.util.Scanner;

public class BOJ11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(convertBase(n, b));
    }

    private static String convertBase(int num, int base) {
        StringBuilder answer = new StringBuilder();
        
        while (num > 0) {
            int now = num % base;
            
            if (now < 10) {
                // 10보다 작은 경우 그대로 저장
                answer.append(now);
            } else {
                // 10 이상인 경우 문자로 변환
                char conv = (char) (now - 10 + 'A');
                answer.append(conv);
            }
            num /= base;
        }
        return answer.reverse().toString();
    }
}
