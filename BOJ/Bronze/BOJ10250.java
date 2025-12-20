import java.io.*;
import java.util.*;

public class BOJ10250 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int remain = n % h;
            // 층 구하기 reamin == 0인 경우는 맨꼭대기 층
            int visitedH = remain == 0 ? h : remain;
            // 호수 구하기 나머지가 있는 경우는 다름 호수로 넘어가는 것으로 +1
            int visitedW = remain != 0 ? n / h + 1 : n / h;
            System.out.println(visitedH * 100 + visitedW);
        }
    }
}