import java.io.*;
import java.util.*;

public class BOJ10432 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int testNum = Integer.parseInt(st.nextToken());

            int[] island = new int[12];
            for (int i = 0; i < 12; i++) {
                island[i] = Integer.parseInt(st.nextToken());
            }
            // 탐색
            int answer = 0;
            // 양끝점을 계산해 하나하나 탐색
            for (int left = 1; left < 11; left++) {
                for (int right = left; right < 11; right++) {
                    boolean isIsland = true;
                    for (int now = left; now <= right; now++) {
                        // 양끝점보다 작은 경우 섬이 아니므로 탈출 및 아님 처리
                        if (island[left - 1] >= island[now] ||
                                island[right + 1] >= island[now]) {
                            isIsland = false;
                            break;
                        }
                    }
                    // 섬인 경우만 1더해주기
                    answer += isIsland ? 1 : 0;
                }
            }
            System.out.println(testNum + " " + answer);
        }
        br.close();
    }
}
