import java.util.*;
import java.io.*;

public class BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // 누적합 적용
        st = new StringTokenizer(br.readLine());
        int[] sumArray = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sumArray[i] = sumArray[i - 1] + Integer.parseInt(st.nextToken());
        }
        // 최대값 구하기
        int answer = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            // i - k ~ i까지 범위의 합은 i까지 합에서 i - k까지 합을 빼면 됨
            answer = Math.max(answer, sumArray[i] - sumArray[i - k]);
        }
        System.out.println(answer);
    }
}
