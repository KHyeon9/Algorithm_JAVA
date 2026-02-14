import java.io.*;
import java.util.*;

public class BOJ4201 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int playerCnt = Integer.parseInt(st.nextToken());
        int potalCnt = Integer.parseInt(st.nextToken());
        int rollCnt = Integer.parseInt(st.nextToken());
        // 뱀이나 사다리에 도착한 경우 이동 위치 셋팅
        int[] map = new int[101];
        for (int i = 0; i < potalCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start] = end;
        }
        // 플레이어 별 위치 셋팅 및 주사위 돌리기
        int[] playerPosition = new int[playerCnt];
        Arrays.fill(playerPosition, 1);
        for (int roll = 0; roll < rollCnt; roll++) {
            int rollResult = Integer.parseInt(br.readLine());
            int nowPlayer = roll % playerCnt;
            int now = playerPosition[nowPlayer] + rollResult;
            // 뱀이나 사다리 있는 경우
            if (now <= 100 && map[now] != 0) {
                now = map[now];
            }
            // 목적지에 도착한 경우 탈출
            if (now >= 100) {
                playerPosition[nowPlayer] = 100;
                break;
            }
            // 위치 변경
            playerPosition[nowPlayer] = now;
        }
        // 출력
        StringBuilder answer = new StringBuilder();
        for (int player = 0; player < playerCnt; player++) {
            answer.append("Position of player ")
                    .append(player + 1)
                    .append(" is ")
                    .append(playerPosition[player])
                    .append(".\n");
        }
        System.out.println(answer);
    }
}
