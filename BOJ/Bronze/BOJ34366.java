import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ34366 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int maxGame = Integer.MIN_VALUE;   // 한 경기 최고 점수
        int minGame = Integer.MAX_VALUE;   // 한 경기 최저 점수
        int maxMonth = 0;                   // 한 달 점수 합 최고
        int minMonth = Integer.MAX_VALUE;   // 한 달 점수 합 최저

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int monthSum = 0;

            for (int j = 0; j < s; j++) {
                int score = Integer.parseInt(st.nextToken());
                maxGame = Math.max(maxGame, score);
                minGame = Math.min(minGame, score);
                monthSum += score;
            }
            maxMonth = Math.max(maxMonth, monthSum);
            minMonth = Math.min(minMonth, monthSum);
        }
        System.out.println(maxGame);
        System.out.println(minGame);
        System.out.println(maxMonth);
        System.out.println(minMonth);
    }
}
