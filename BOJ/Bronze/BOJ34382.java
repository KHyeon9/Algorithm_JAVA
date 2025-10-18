import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ34382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        double[] sensor = new double[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            sensor[i] = Double.parseDouble(br.readLine());
            total += sensor[i];
        }
        // 평균 구하기
        double avg = total / n;
        int res = 0;
        // 오차값이 특정 값 이상 혹은 이하일 경우 res + 1
        for (double val : sensor) {
            if (Math.abs(val - avg) > 10.0) {
                res++;
            }
        }

        System.out.println(res);
    }
}
