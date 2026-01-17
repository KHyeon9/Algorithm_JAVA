import java.io.*;
import java.util.*;

public class BOJ12865 {
    static class Backpack {
        int weight, value;

        public Backpack(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());
        // 백팩 셋팅
        Backpack[] backpacks = new Backpack[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            backpacks[i] = new Backpack(weight, value);
        }
        // 냅색 알고리즘 (dp)
        int[][] dp = new int[cnt + 1][maxWeight + 1];
        for (int idx = 1; idx <= cnt; idx++) {
            Backpack nowBackpack = backpacks[idx];
            for (int weight = 1; weight <= maxWeight; weight++) {
                if (nowBackpack.weight > weight) {
                    // 음수일 경우 처리
                    // 이전에 값이 있으면 그 값으로 사용
                    dp[idx][weight] = dp[idx - 1][weight];
                } else {
                    // 이전의 값중 현재 값을 뺐을때 max보다 작은경우
                    // 최대값 구하기
                    int before = dp[idx - 1][weight - nowBackpack.weight];
                    dp[idx][weight] = Math.max(
                            dp[idx - 1][weight],
                            before + nowBackpack.value
                    );
                }
            }
        }
        System.out.println(dp[cnt][maxWeight]);
    }
}
