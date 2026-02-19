import java.util.*;

public class BOJ5367 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        // 출력 셋팅
        StringBuilder answer = new StringBuilder();
        // 시작줄
        answer.append("|")
                .append("-".repeat(size - 2))
                .append("|")
                .append("\n");
        for (int i = 0; i < size - 2; i++) {
            // 해당 라인의 시작과 끝 |처리
            answer.append("|");
            for (int j = 0; j < size - 2; j++) {
                // 점 양쪽을 서로 반대 방향으로 이동
                if (i == j || size - 3 - i == j) {
                    answer.append("*");
                } else {
                    answer.append(" ");
                }
            }
            answer.append("|").append("\n");
        }
        // 끝나는 줄
        answer.append("|")
                .append("-".repeat(size - 2))
                .append("|");
        System.out.println(answer);
        sc.close();
    }
}
