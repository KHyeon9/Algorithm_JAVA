import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ34310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cnt = new int[3];
        int idx;
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String p = st.nextToken();
            String inAndOut = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            // 사람 종류에 따른 인덱스 변경
            if (Objects.equals(p, "STU")) {
                idx = 0;
            } else if (Objects.equals(p, "FAC")) {
                idx = 1;
            } else {
                idx = 2;
            }
            // 들어가고 나가는 사람에 따른 변경
            if (inAndOut.equals("IN")) {
                cnt[idx] += num;
            } else {
                cnt[idx] -= num;
            }
        }
        // 출력 조건 처리
        int total = Arrays.stream(cnt).sum();
        if (total == 0) {
            System.out.println("NO STRAGGLERS");
        } else {
            System.out.println(total);
        }
    }
}
