import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1010 {
    static int[][] dp = new int[31][31];
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(combi(m, n));
        }
    }
    
    private static int combi(int row, int col) {
        // 0이 아님 반환
        if (dp[row][col] > 0) {
            return dp[row][col];
        }
        // 행이 0인거나 row와 col이 같으면 1
        // 행이 0인 경우는 값을 계산하기 위해
        // row == col은 고를수 있는 값과 고르는 값이 같이서 1밖이없음
        if (col == 0 || row == col) {
            return dp[row][col] = 1;
        }
        // nCr은 (n - 1)C(r - 1) + (n - 1)C(r)이 공식이라
        // 재귀를 활용해 탑에서 바텀으로 내려가면서 계싼
        return dp[row][col] = combi(row - 1, col - 1) + combi(row - 1, col);
    }
}
