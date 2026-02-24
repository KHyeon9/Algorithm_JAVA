import java.io.*;
import java.util.*;

public class BOJ7696 {
    static boolean[] visited = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int num = 1, idx = 1;
        int[] answerList = new int[1000001];
        while (idx <= 1000000) {
            if (isOk(num)) {
                answerList[idx++] = num;
            }
            num++;
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            // 탈출 조건
            if (n == 0) {
                break;
            }
            // 출력
            System.out.println(answerList[n]);
        }
        br.close();
    }

    private static boolean isOk(int num) {
        // 메모리 초과를 피하기위해 fill을 통해 재생성을 막음
        Arrays.fill(visited, false);
        // 각 숫자에 중복있는지 확인
        while (num > 0) {
            int digit = num % 10;
            if (visited[digit]) return false;
            visited[digit] = true;
            num /= 10;
        }
        return true;
    }
}

