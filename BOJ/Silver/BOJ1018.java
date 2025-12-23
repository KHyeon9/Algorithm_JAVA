import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {
    static String[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
       board = new String[n];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        int minCnt = Integer.MAX_VALUE;
        // 시작점을 정해야하기 때문에 2중 반복문
        // 8 * 8 범위를 도는데 -7 하지 않으면 index 오류 발생
        for (int row = 0; row < n - 7; row++) {
            for (int col = 0; col < m - 7; col++) {
                minCnt = Math.min(minCnt, checkCnt(row, col));
            }
        }

        System.out.println(minCnt);
    }
    // 시작점에서 8 * 8 크기를 돌며 최소 갯수 찾기
    private static int checkCnt(int y, int x) {
        int cnt1 = 0, cnt2 = 0;

        for (int row = y; row < y + 8; row++) {
            for (int col = x; col < x + 8; col++) {
                if (row % 2 == 0) {
                    if (col % 2 == 0) {
                        if (board[row].charAt(col) == 'W') {
                            cnt1++;
                        } else {
                            cnt2++;
                        }
                    } else {
                        if (board[row].charAt(col) == 'B') {
                            cnt1++;
                        } else {
                            cnt2++;
                        }
                    }
                } else {
                    if (col % 2 == 0) {
                        if (board[row].charAt(col) == 'B') {
                            cnt1++;
                        } else {
                            cnt2++;
                        }
                    } else {
                        if (board[row].charAt(col) == 'W') {
                            cnt1++;
                        } else {
                            cnt2++;
                        }
                    }
                }
            }
        }

        return Math.min(cnt1, cnt2);
    }
}
