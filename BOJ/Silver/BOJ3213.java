import java.io.*;
import java.util.*;

public class BOJ3213 {
    static Map<String, Integer> pizzaSizeMap = Map.of(
            "1/4", 0,
            "1/2", 1,
            "3/4", 2
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int friendCnt = Integer.parseInt(br.readLine());
        // 각 친구의 피자 먹는 양 받기
        int[] sizeCnt = new int[3];
        for (int i = 0; i < friendCnt; i++) {
            String pizzaSize = br.readLine();
            sizeCnt[pizzaSizeMap.get(pizzaSize)]++;
        }
        int cnt = sizeCnt[2];
        // 1/2와 1/4 계산을 위한 나머지
        int remain = Math.max(0, sizeCnt[0] - sizeCnt[2]);
        // 1/2의 사이즈로 피자 갯수 추가
        cnt += sizeCnt[1] / 2;
        // 만약 1/2사이즈가 남아있는 경우
        if (sizeCnt[1] % 2 == 1) {
            cnt++;
            // 나머지에 값이 있으면 계산
            remain = Math.max(remain - 2, 0);
        }
        // 4명당 1판이므로 나머지 았으면 추가
        int answer = cnt + (remain + 3) / 4;
        System.out.println(answer);
    }
}
