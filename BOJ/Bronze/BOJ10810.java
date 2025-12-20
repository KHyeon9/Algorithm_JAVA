import java.util.*;
import java.io.*;

public class BOJ10810 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] buckets = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            // 버킷의 값을 시작점부터 끝점까지 주어진 값으로 변경
            for (int bucket = start; bucket <= end; bucket++) {
                buckets[bucket] = number;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(buckets[i] + " ");
        }

        System.out.println(sb);
    }
}
