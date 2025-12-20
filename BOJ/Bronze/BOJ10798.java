import java.util.Scanner;

public class BOJ10798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lines = new String[5];

        for (int i = 0; i < 5; i++) {
            lines[i] = sc.next();
        }

        StringBuilder answer = new StringBuilder();
        for (int col = 0; col < 15; col++) {
            for (int row = 0; row < 5; row++) {
                String now = lines[row];
                // 문자열의 최대 길이가 넘지 않으면 입력 받기
                if (now.length() > col) {
                    answer.append(now.charAt(col));
                }
            }
        }

        System.out.println(answer);
    }
}