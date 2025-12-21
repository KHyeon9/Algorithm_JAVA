import java.util.Scanner;

public class BOJ1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    private static String solution(int num) {
        int sum = 0;
        int line = 0;
        // sum + line보다 작아야 몇번째 대각선인지 구할수 있음
        while (sum + line < num) {
            sum += line;
            line++;
        }
        // 해당 대각선이 내에서 몇번째인지 확인
        int pos = num - sum;
        // 방향 전환 조건
        int row, col;
        if (line % 2 == 0) {
            // 대각선이 짝수번째인 경우 위에서 아래로
            row = pos; // 몇번째 위치에 따라 변환
            col = line - pos + 1;
        } else {
            // 대각선이 홀수번째인 경우 아래에서 위
            row = line - pos + 1;
            col = pos;
        }

        return row + "/" + col;
    }

    // 개선전 로직
    private static String solution2(int num) {
        int temp = 0;
        int now = 0;

        while (temp < num) {
            temp += ++now;
        }
        // 방향 전환 조건
        boolean flag = now % 2 == 0;
        // 방향에 따른 row와 col 위치 조정
        int row = flag ? 1 : now;
        int col = !flag ? 1 : now;
        // 이동 방향 셋팅
        int dRow = flag ? 1 : -1;
        int dCol = !flag ? 1 : -1;
        // 이동 횟수
        // 현제 이동하는 줄의 원소 갯수 - 이전 지나간 원소들 -1
        int move = now - (temp - num) - 1;

        row += dRow * move;
        col += dCol * move;

        return row + "/" + col;
    }
}