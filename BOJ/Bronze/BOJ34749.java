import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ34749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] maxCnt = new int[m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // 입력 받은 과일 index에 해당한 최대값 구하기
            for (int j = 0; j < m; j++) {
                int nowCnt = Integer.parseInt(st.nextToken());
                maxCnt[j] = Math.max(maxCnt[j], nowCnt);
            }
        }
        // 배열 원소들의 총합
        System.out.println(Arrays.stream(maxCnt).sum());
    }
}
