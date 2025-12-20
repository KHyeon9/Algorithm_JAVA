import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10811 {
    public static void main(String[] args) throws Exception{
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] buckets = new int[n + 1];
        // 초기화
        for (int i = 1; i <= n; i++) {
            buckets[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = end - start + 1;
            // 범위만틈 배열을 거꾸로 저장
            int[] tempArr = new int[len];
            for (int j = 0; j < len; j++) {
                tempArr[j] = buckets[end--];
            }
            // 범위만큼 변경
            for (int j = 0; j < len; j++) {
                buckets[start + j] = tempArr[j];
            }
        }
        br.close();

        // 출력 작업
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(buckets[i] + " ");
        }

        System.out.println(sb);
    }
}
