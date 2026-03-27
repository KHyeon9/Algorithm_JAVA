import java.io.*;
import java.util.*;

public class BOJ33257 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        // 입력 받기
        st = new StringTokenizer(br.readLine());
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬하여 찾기 쉽도록 함
        Arrays.sort(weights);
        // 같은 물질의 탑입 갯수 세기
        int answer = 1;
        for (int i = 0; i < n - 1; i++) {
            // 2개 추의 차이가 오차 범위 밖이면 타입 증가
            if (Math.abs(weights[i] - weights[i + 1]) >= e) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
