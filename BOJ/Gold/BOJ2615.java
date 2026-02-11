import java.io.*;
import java.util.*;

public class BOJ2615 {
    static class PlayInfo {
        int color, row, col;

        public PlayInfo(int color, int row, int col) {
            this.color = color;
            this.row = row;
            this.col = col;
        }
    }
    // 오른쪽, 아래, 좌하향, 우하향 검사
    static int[] dRow = {1, 0, 1, 1};
    static int[] dCol = {0, 1, -1, 1};
    static int[][] baduk;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        baduk = new int[20][20];
        for (int r = 1; r <= 19; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= 19; c++) {
                baduk[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        PlayInfo winner = null;
        for (int r = 1; r <= 19; r++) {
            for (int c = 1; c <= 19; c++) {
                // 빈공간이 아닌 경우
                if (baduk[r][c] != 0) {
                    // 승자 확인
                    PlayInfo nowWinInfo = whoWin(baduk[r][c], r, c);
                    // 승자가 있으면 승자 셋팅
                    if (nowWinInfo != null) {
                        winner = nowWinInfo;
                    }
                }
            }
            // 승자가 있으면 탈출
            if (winner != null) {
                break;
            }
        }
        // 승자가 없으면 0 반환
        if (winner == null) {
            System.out.println(0);
        } else {
            // 승자가 있는 경우 색과 맨 왼쪽의 위치 반환
            System.out.println(winner.color);
            System.out.println(winner.row + " " + winner.col);
        }
    }

    private static PlayInfo whoWin(int color, int row, int col) {
        for (int i = 0; i < 4; i++) {
            // 이전 바둑돌 검사 
            int prevRow = row - dRow[i];
            int prevCol = col - dCol[i];
            // 해당 바둑돌이 현재와 같은경우 6목 방지를 위한 검사
            if (isMove(prevRow, prevCol) && baduk[prevRow][prevCol] == color) {
                continue;
            }
            // 현재 시작점 값으로 갯수 초기화
            int cnt = 1;
            int nowRow = row, nowCol = col;
            while (true) {
                // 다음 위치 셋팅
                nowRow += dRow[i];
                nowCol += dCol[i];
                // 범위 벗어나거나 돌이 아닌 경우
                if (!isMove(nowRow, nowCol) || baduk[nowRow][nowCol] != color) {
                    // 마지막 위치 셋팅
                    nowRow -= dRow[i];
                    nowCol -= dCol[i];
                    break;
                }
                // 같은 색이면 연결 갯수 +1
                cnt++;
            }
            // 오목 완성인 경우
            if (cnt == 5) {
                // 좌하향인 경우 맨 왼쪽 돌이 마지막 돌임
                if (i == 2) {
                    return new PlayInfo(color, nowRow, nowCol);
                }
                // 좌하향이 아닌 경우 시작점이 맨 왼쪽 돌임
                return new PlayInfo(color, row, col);
            }
        }
        // 승자 없는 경우 null
        return null;
    }
    // 이동 가능한 위치 확인
    private static boolean isMove(int row, int col) {
        return (1 <= row && row < 20) && (1 <= col && col < 20);
    }
}
