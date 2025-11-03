import java.util.Scanner;

public class BOJ9663 {
    static int[] chessBoard;
    static int N;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        chessBoard = new int[N];
        backtracking(0);
        System.out.println(cnt);
    }

    public static void backtracking(int row) {
        // N개의 queen 배치시 cnt 1 증가
        if (row == N) {
            cnt++;
            return;
        }
        // 행을 돌면서 놓을 수 있는지 확인
        for (int i = 0; i < N; i++) {
            chessBoard[row] = i;
            if (check(row)) {
                backtracking(row + 1);
            }
        }
    }
    // queen을 놓을 수 있는지 유효성 검사
    private static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            // 일직선 확인 (행으로 움직이면서 확인하기 때문에 열은 확인 필요 x)
            if (chessBoard[i] == chessBoard[row]) {
                return false;
            }
            // 대각선 확인
            if (Math.abs(row - i) == Math.abs(chessBoard[row] - chessBoard[i])) {
                return false;
            }
        }
        return true;
    }
}
