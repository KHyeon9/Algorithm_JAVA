import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9184 {
    // 메모이제이션을 위한 dp 배열 선언
    static int[][][] dp = new int[51][51][51];

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        // 반복문 시작
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 탈출 조건
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            // 출력
            System.out.println(String.format(
                    "w(%d, %d, %d) = %d", a, b, c, recursion(a, b, c))
            );
        }
    }
    // 문제에서 주어진 조건
    private static int recursion(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        } else if (a > 20 || b > 20 || c > 20) {
            return dp[a][b][c] = recursion(20, 20, 20);
        } else if (a < b && b < c) {
            return dp[a][b][c] =
                    recursion(a, b, c-1) +
                    recursion(a, b-1, c-1) -
                    recursion(a, b-1, c);
        } else {
            return dp[a][b][c] =
                    recursion(a-1, b, c) +
                    recursion(a-1, b-1, c) +
                    recursion(a-1, b, c-1) -
                    recursion(a-1, b-1, c-1);
        }
    }
}
