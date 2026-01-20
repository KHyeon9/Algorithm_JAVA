import java.io.*;
import java.util.*;

public class BOJ2583 {
    static class PosInfo {
        int row, col;

        public PosInfo (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 직사각형 그리기
        boolean[][] paper = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int col1 = Integer.parseInt(st.nextToken());
            int row1 = Integer.parseInt(st.nextToken());
            int col2 = Integer.parseInt(st.nextToken());
            int row2 = Integer.parseInt(st.nextToken());

            for (int r = row1; r < row2; r++) {
                for (int c = col1; c < col2; c++) {
                    paper[r][c] = true;
                }
            }
        }
        // 영역 찾기
        int answerCnt = 0;
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (!paper[row][col]) {
                    answerList.add(
                            BFS(new PosInfo(row, col), m, n, paper));
                    answerCnt++;
                }
            }
        }
        answerList.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        sb.append(answerCnt + "\n");
        for (int cnt : answerList) {
            sb.append(cnt + " ");
        }
        System.out.println(sb);
    }
    // BFS로 방문처리
    private static int BFS(
            PosInfo start,
            int rowSize, int colSize,
            boolean[][] paper
    ) {
        int answer = 1;
        // 이동 방향 셋팅
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        // 덱과 방문 처리
        paper[start.row][start.col] = true;
        Deque<PosInfo> posDeq = new ArrayDeque<>();
        posDeq.addLast(start);
        // 탐색
        while (!posDeq.isEmpty()) {
            PosInfo now = posDeq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextRow = now.row + dRow[i];
                int nextCol = now.col + dCol[i];

                if (canMove(nextRow, nextCol, rowSize, colSize) &&
                        !paper[nextRow][nextCol]
                ) {
                    paper[nextRow][nextCol] = true;
                    posDeq.addLast(new PosInfo(nextRow, nextCol));
                    answer++;
                }
            }
        }
        return answer;
    }

    private static boolean canMove(int row, int col, int rowSize, int colSize) {
        return (0 <= row && row < rowSize) && (0 <= col && col < colSize);
    }
}
