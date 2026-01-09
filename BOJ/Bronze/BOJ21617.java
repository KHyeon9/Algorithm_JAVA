import java.util.*;
import java.io.*;

public class BOJ21617 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        // 높이 받기
        st = new StringTokenizer(br.readLine());
        double[] hieghts = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            hieghts[i] = Integer.parseInt(st.nextToken());
        }
        // 밑변 길이 받기
        st = new StringTokenizer(br.readLine());
        double[] widths = new double[n];
        for (int i = 0; i < n; i++) {
            widths[i] = Integer.parseInt(st.nextToken());
        }
        // 계산
        double answer = 0;
        for (int i = 1; i <= n; i++) {
            double sumHeight = hieghts[i - 1] + hieghts[i];
            answer += (sumHeight * widths[i - 1]) / 2;
        }
        System.out.println(answer);
    }
}
