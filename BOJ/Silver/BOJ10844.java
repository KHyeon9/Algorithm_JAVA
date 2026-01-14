import java.util.*;

public class BOJ10844 {
    static long MOD = 1000000000;
    static long[][] dp = new long[101][10];
    static {
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 각 이전 숫자에 따른 계산
        // 현재 위치의 숫자를 제외한 이전 위치의 양쪽 값을 더함
        for (int i = 2; i <= n; i++) {
            // 0은 이전 1번의 값을 저장
            // 다음 1의 값을 계산하기 위해 저장
            dp[i][0] = dp[i - 1][1] % MOD;
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
            // 9인 경우 8밖이 선택 못하므로 이전 8값에서 가져옴
            dp[i][9] = (dp[i - 1][8]) % MOD;
        }
        // 구하려는 길이의 총 갯수 구하기
        long answer = 0;
        for (int i = 1; i < 10; i++) {
            answer = (answer +  dp[n][i]) % MOD;
        }
        System.out.println(answer % MOD);
    }
}
