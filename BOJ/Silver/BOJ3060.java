import java.io.*;
import java.util.*;

public class BOJ3060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            long totalFood = Integer.parseInt(br.readLine());
            // 각 돼지가 먹는 양 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sum = 0;
            for (int i = 0; i < 6; i++) {
                // 첫째주 사용한 사료양 계산
                sum += Integer.parseInt(st.nextToken());
            }
            int answer = 1;
            // 2번째 바퀴부터 확인
            while (totalFood >= sum) {
                sum *= 4;
                answer++;
            }
            System.out.println(answer);
        }
    }
}
