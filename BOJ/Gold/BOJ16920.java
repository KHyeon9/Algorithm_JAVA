import java.io.*;
import java.util.*;

public class BOJ16920 {
    static class PosInfo {
        int player, row, col;

        public PosInfo(int player, int row, int col) {
            this.player = player;
            this.row = row;
            this.col = col;
        }
    }
    static int rowSize;
    static int colSize;
    static int[][] board;
    static boolean[][] visted;
    static int[] playersStep;
    // 이동 방향
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        int playerCnt = Integer.parseInt(st.nextToken());
        // visited setting
        visted = new boolean[rowSize][colSize];
        // 각 플레이어의 스텝 받기
        st = new StringTokenizer(br.readLine());
        playersStep = new int[playerCnt + 1];
        for (int player = 1; player <= playerCnt; player++) {
            playersStep[player] = Integer.parseInt(st.nextToken());
        }
        // board and posList setting
        ArrayList<PosInfo> playersPos = new ArrayList<>();
        board = new int[rowSize][colSize];
        for (int r = 0; r < rowSize; r++) {
            String line = br.readLine();
            for (int c = 0; c < colSize; c++) {
                char ch = line.charAt(c);
                int change;
                // 플레이어면 플레이어 저장 및 숫자 저장
                if (ch != '#' && ch != '.') {
                    change = (ch - '0');
                    playersPos.add(new PosInfo(change, r, c));
                } else {
                    // 벽이나 빈 공간인 경우 빈공간은 0 벽이면 -1
                    change = ch == '.' ? 0 : -1;
                }
                board[r][c] = change;
            }
        }
        // 출력
        StringBuilder sb = new StringBuilder();
        int[] answer = getGameResult(playersPos, playerCnt);
        for (int i = 1; i <= playerCnt; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static int[] getGameResult(ArrayList<PosInfo> playersPos, int playerCnt) {
        int[] answer = new int[playerCnt + 1];
        // visited, deque 셋팅
        ArrayDeque<PosInfo>[] playerDeq = new ArrayDeque[playerCnt + 1];
        for (int i = 0; i <= playerCnt; i++) {
            playerDeq[i] = new ArrayDeque<>();
        }
        for (PosInfo player : playersPos) {
            visted[player.row][player.col] = true;
            answer[player.player]++;
            playerDeq[player.player].add(player);
        }
        // 탐색
        while (true) {
            boolean isMove = false;
            // 각 플레이서 순서대로 각 덱을 바탕으로 탐색
            for (int p = 1; p <= playerCnt; p++) {
                // 스텝 만큼 반복
                for (int s = 0; s < playersStep[p]; s++) {
                    // 스텝 횟수 만큼 size를 계산해 확장
                    int deqSize = playerDeq[p].size();
                    // 사이즈 없으면 바로 탈출
                    if (deqSize == 0) break;
                    for (int t = 0; t < deqSize; t++) {
                        PosInfo now = playerDeq[p].pollFirst();
                        // 상하좌우 탐색
                        for (int i = 0; i < 4; i++) {
                            int nextRow = now.row + dRow[i];
                            int nextCol = now.col + dCol[i];
                            // 이동 가능하고 방문하지 않은 경우
                            if (canMove(nextRow, nextCol) && !visted[nextRow][nextCol]) {
                                visted[nextRow][nextCol] = true;
                                answer[now.player]++;
                                playerDeq[now.player].addLast(new PosInfo(now.player, nextRow, nextCol));
                                isMove = true;
                            }
                        }
                    }
                }
            }
            // 이동할 곳 없으면 탈출
            if (!isMove) {
                break;
            }
        }

        return answer;
    }
    // 이동 가능한지 확인
    private static boolean canMove(int row, int col) {
        return (0 <= row  && row < rowSize) &&
                (0 <= col && col < colSize) &&
                (board[row][col] == 0);
    }
}
