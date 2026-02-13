import java.io.*;
import java.util.*;

public class BOJ2303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int playerCnt = Integer.parseInt(br.readLine());
        int winner = 0, maxSocre = 0;
        for (int player = 1; player <= playerCnt; player++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] nowCards = new int[5];
            for (int j = 0; j < 5; j++) {
                nowCards[j] = Integer.parseInt(st.nextToken());
            }
            // 점수 계산
            int nowScore = calcScore(nowCards);
            if (nowScore >= maxSocre) {
                winner = player;
                maxSocre = nowScore;
            }
        }
        System.out.println(winner);
    }
    // 점수 계산
    private static int calcScore(int[] nowCards) {
        int answer = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    // 10의로 나눈 나머지와 비교
                    answer = Math.max(
                            answer,
                            (nowCards[i] + nowCards[j] + nowCards[k]) % 10
                    );
                }
            }
        }
        return answer ;
    }
}
