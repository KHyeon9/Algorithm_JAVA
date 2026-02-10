import java.io.*;
import java.util.*;

public class BOJ5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            int numberCnt = Integer.parseInt(br.readLine());
            // 번호 받기
            String[] numbers = new String[numberCnt];
            for (int i = 0; i < numberCnt; i++) {
                numbers[i] = br.readLine();
            }
            // 사전순 정렬
            Arrays.sort(numbers);

            boolean flag = true;
            for (int i = 1; i < numberCnt; i++) {
                // 사전순 정렬로 접두사가 비슷한 것끼리 묶임
                if (numbers[i].startsWith(numbers[i - 1])){
                    // 접두사인 경우 flag 처리 및 탈출
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
        br.close();
    }
}
