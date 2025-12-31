import java.io.*;
import java.util.*;

public class BOJ32400 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] score = new int[20];
        double sum = 0;
        int maxIdx = 0;
        for (int i = 0; i < 20; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            // 전체 점수 총합 계산
            sum += score[i];
            // 가장큰 값 idx 저장
            if (score[i] == 20) {
                maxIdx = i;
            }
        }
        // 평균값 구하기
        double bob = sum / 20;
        double alice = 20;
        if (maxIdx == 0) {
            alice += score[maxIdx + 1] + score[19];
        } else if (maxIdx == 19) {
            alice += score[0] + score[maxIdx - 1];
        } else {
            alice += score[maxIdx - 1] + score[maxIdx + 1];
        }
        alice /= 3;
        // 출력
        if (alice > bob) {
            System.out.println("Alice");
        } else if (alice < bob) {
            System.out.println("Bob");
        } else {
            System.out.println("Tie");
        }
    }
}
