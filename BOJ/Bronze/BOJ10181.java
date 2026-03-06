import java.io.*;
import java.util.*;

public class BOJ10181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int num = sc.nextInt();
            // 탈출 조건
            if (num == -1) {
                break;
            }
            // 약수들과 총합 저장
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;
                    list.add(i);
                }
            }
            // 출력
            StringBuilder answer = new StringBuilder();
            answer.append(num);
            if (sum == num) {
                answer.append(" = ");
                for (int i = 0; i < list.size(); i++) {
                    answer.append(list.get(i));
                    if (i < list.size() - 1) {
                        answer.append(" + ");
                    }
                }
            } else {
                answer.append(" is NOT perfect.");
            }
            System.out.println(answer);
        }
        sc.close();
    }
}
