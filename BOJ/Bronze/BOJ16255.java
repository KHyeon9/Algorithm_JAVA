import java.io.*;
import java.util.*;

public class BOJ16255 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int test = 0; test < testCase; test++) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 두 사람중 더 큰 점수 구하기
            int maxGoal = Math.max(x, y);
            // 두 팀의 점수 차가 2보다 작은 경우 더해주기
            int gap = Math.abs(x - y);
            if (gap < 2) {
                maxGoal += 2 - gap;
                answer += 2 - gap;
            }
            // 최대 점수가 k보다 작으면 k와 차이만큼 더하기
            if (k > maxGoal) {
                answer += (k - maxGoal);
            }

            System.out.println(answer);
        }
    }
}
