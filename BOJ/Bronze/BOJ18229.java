import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        // 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
               arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(arr, n, m, k));
    }
    
    private static String solution(int[][] arr, int n, int m, int k) {
        int[] sumList = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sumList[j] += arr[j][i];
                // 합이 k 이상일 경우 출력
                if (sumList[j] >= k) {
                    return (j + 1) + " " + (i + 1);
                }
            }
        }
        return "값이 없습니다.";
    }
}
