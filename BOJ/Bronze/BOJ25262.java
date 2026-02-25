import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25262 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] dayInfo = br.readLine().toCharArray();
        // 미방문 연속일 계산
        int max = 0, cnt = 0;
        for (char info : dayInfo) {
            if (info == '1') {
                max = Math.max(max, cnt);
                cnt = 0;
            } else {
                cnt++;
            }
        }
        // 남은 갯수 비교
        max = Math.max(max, cnt);
        System.out.println(max < k ? 1 : 0);
    }
}
