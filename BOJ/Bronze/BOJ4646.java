import java.io.*;
import java.util.*;

public class BOJ4646 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());
            // 탈출 조건
            if (cnt == 0) break;
            // 누적 합
            int[] sumList = new int[cnt + 1];
            for (int i = 1; i <= cnt; i++) {
                int num = Integer.parseInt(st.nextToken());
                sumList[i] = sumList[i - 1] + num;
            }
            // 두 값 구하기
            int answer1 = -1, answer2 = -1;
            for (int i = 1; i <= cnt; i++) {
                // 현재합과 나머지의 합이 같으면 저장
                if (sumList[i] == sumList[cnt] - sumList[i]) {
                    answer1 = i;
                    answer2 = i + 1;
                }
            }
            // 값이 없으면 출력
            if (answer1 == -1) {
                System.out.println("No equal partitioning.");
            } else {
                // 값이 존재하면 위치 출력
                System.out.printf("Sam stops at position %d and Ella stops at position %d.\n", answer1, answer2);
            }
        }
    }
}
