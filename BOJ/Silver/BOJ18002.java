import java.io.*;
import java.util.*;

public class BOJ18002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        // 무게 받고 총합 무게 구하기
        long[] weightCnt = new long[200001];
        long totalWeight = 0;
        for (int i = 0; i < cnt; i++) {
            int weight = Integer.parseInt(br.readLine());
            totalWeight += weight;
            weightCnt[weight]++;
        }
        br.close();
        // 계산
        long leftSum = 0;
        int answer = -1;
        for (int weight = 1; weight <= 200000; weight++) {
            long currSumWeight = weightCnt[weight] * weight;
            long rightSum = totalWeight - leftSum - currSumWeight;
            // 왼쪽과 오른쪽의 무게가 같으면 탈출
            if (leftSum == rightSum) {
                answer = weight;
                break;
            }
            leftSum += currSumWeight;
        }
        System.out.println(answer);
    }
}
