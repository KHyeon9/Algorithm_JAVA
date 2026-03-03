import java.io.*;
import java.util.*;

public class BOJ11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            int days = Integer.parseInt(br.readLine());
            // 주가 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] stockPrices = new long[days];
            for (int i = 0; i < days; i++) {
                stockPrices[i] = Long.parseLong(st.nextToken());
            }
            // 결과 계산
            long nowMax = stockPrices[days - 1];
            long answer = 0L;
            for (int i = days - 1; i >= 0 ; i--) {
                // 현재 최대값보다 크면 변경
                if (nowMax < stockPrices[i]) {
                    nowMax = stockPrices[i];
                } else {
                    // 최대값보다 작으면 차이 더해주기
                    answer += nowMax - stockPrices[i];
                }
            }
            System.out.println(answer);
        }
        br.close();
    }
}
