import java.util.*;

public class BOJ35213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        // 최대 세제곱값 구하기
        int maxNum = 1;
        while ((maxNum + 1) * (maxNum + 1) * (maxNum + 1) <= num) {
            maxNum++;
        }
        // 출력
        StringBuilder answer = new StringBuilder();
        // 갯수 구하기 및 출력
        int remain = maxNum * maxNum * maxNum;
        answer.append(num - remain + 1).append("\n");
        answer.append(maxNum).append(" ");
        for (int i = 0; i < (num - remain); i++) {
            answer.append(1 + " ");
        }
        System.out.println(answer);
    }
}
