import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }
        // 큰 수부터 비교하므로 역순번
        for (int i = n - 1; i > -1; i--) {
            // 현재 돈보다 동전보다 크면 다음으로
            if (coins[i] > k) continue;
            // 사용한 코인의 갯수 추가
            cnt += k / coins[i];
            // 현재 남은 가치 변경
            k = k % coins[i];
        }

        System.out.println(cnt);
    }
}
