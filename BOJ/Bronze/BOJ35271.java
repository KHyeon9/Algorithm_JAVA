import java.io.*;
import java.util.*;

public class BOJ35271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 티오 저장
        st = new StringTokenizer(br.readLine());
        int[] TO = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            TO[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder answer = new StringBuilder();
        // 지망 1등부터 찾기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int go = -1;
            for (int j = 0; j < 3; j++) {
                int want = Integer.parseInt(st.nextToken());
                // 티오가 남아있으면 해당 자대로 지정
                if (TO[want] > 0) {
                    go = want;
                    TO[want]--;
                    break;
                }
            }
            answer.append(go + " ");
        }
        System.out.println(answer);
        br.close();
    }
}
