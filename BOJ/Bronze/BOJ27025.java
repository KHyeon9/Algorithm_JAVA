import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ27025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int now = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tree1 = Integer.parseInt(st.nextToken());
            int tree2 = Integer.parseInt(st.nextToken());
            // 2개의 위치 중에 1개라도 나무가 있는 경우
            if (tree1 == 1 || tree2 == 1) {
                answer = Math.max(answer, now);
                now = 0;
                continue;
            }
            now++;
        }
        // 마지막 로직 처리
        answer = Math.max(answer, now);
        System.out.println(answer * 2);
    }
}
