import java.io.*;
import java.util.*;

public class BOJ14654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cnt = Integer.parseInt(br.readLine());
        
        int[] team1 = new int[cnt];
        int[] team2 = new int[cnt];
        // 팀 1, 2 셋팅
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            team1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            team2[i] = Integer.parseInt(st.nextToken());
        }
        int lastWinner = 0;
        int winningStreak1 = 0;
        int winningStreak2 = 0;
        int maxWinningStreak = 0;

        for (int i = 0; i < cnt; i++) {
            int whoWin = whoWin(team1[i], team2[i], lastWinner);
            if (whoWin == 1) {
                // 팀1이 이기는 경우 연승 증가 및 2팀 연승 초기화
                winningStreak1++;
                winningStreak2 = 0;
                // 이긴 팀 저장
                lastWinner = 1;
            } else {
                // 팀2이 이기는 경우 연승 증가 및 1팀 연승 초기화
                winningStreak2++;
                winningStreak1 = 0;
                // 이긴 팀 저장
                lastWinner = 2;
            }
            maxWinningStreak = Math.max(
                    maxWinningStreak,
                    Math.max(
                            winningStreak1,
                            winningStreak2
                    )
                );
        }

        System.out.println(maxWinningStreak);
    }

    private static int whoWin(int team1, int team2, int lastWin) {
        // 비긴 경우 이전 우승 팀 반대가 이김 처리
        if (lastWin != 0 && team1 == team2) {
            return lastWin == 1 ? 2 : 1;
        }
        // team1이 이기는 경우
        if (team1 == 1 && team2 == 3 ||
            team1 == 2 && team2 == 1 ||
            team1 == 3 && team2 == 2
        ) {
            return 1;
        }
        // 나머진 team2가 이기는 경우
        return 2;
    }
}
