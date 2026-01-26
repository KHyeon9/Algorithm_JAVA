import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ6986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int removeCnt = Integer.parseInt(st.nextToken());
        // 점수 받기
        double[] scores = new double[cnt];
        for (int i = 0; i < cnt; i++) {
            scores[i] = Double.parseDouble(br.readLine());
        }
        // 정렬
        Arrays.sort(scores);
        // 절사 평균 계산할 수의 합
        double answer1 = 0;
        for (int i = removeCnt; i < cnt - removeCnt; i++) {
            answer1 += scores[i];
        }
        // 보정 평균 계산할 수의 합
        double answer2 = scores[removeCnt] * removeCnt + answer1 + scores[cnt - removeCnt - 1] * removeCnt;
        // 절사 평균과 보정 평균의 값 구하기
        answer1 /= (cnt - removeCnt * 2);
        answer2 /= cnt;
        System.out.printf("%.2f\n%.2f", answer1, answer2);

    }
}
