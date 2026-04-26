import java.io.*;

public class BOJ12629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            int n = Integer.parseInt(br.readLine());
            // 배열 만들고 마지막 1의 위치 저장
            int[][] arr = new int[n][n];
            int[] lastOneIdx = new int[n];
            for (int r = 0; r < n; r++) {
                String row = br.readLine();
                for (int c = 0; c < n; c++) {
                    arr[r][c] = row.charAt(c) - '0';
                    if (arr[r][c] == 1) {
                        lastOneIdx[r] = c;
                    }
                }
            }
            // 결과 계산
            int answer = 0;
            for (int r = 0; r < n; r++) {
                // 현재 맞는 위치면 넘어감
                if (lastOneIdx[r] <= r) {
                    continue;
                }
                // 불가능한 위치면 다음행의 맞는 위치 찾기
                int findIdx = -1;
                for (int idx = r + 1; idx < n; idx++) {
                    if (lastOneIdx[idx] <= r) {
                        findIdx = idx;
                        break;
                    }
                }
                // 가능한 위치까지 원소 스왑
                for (int idx = findIdx; idx > r; idx--) {
                    int temp = lastOneIdx[idx];
                    lastOneIdx[idx] = lastOneIdx[idx - 1];
                    lastOneIdx[idx - 1] = temp;
                    answer++;
                }
            }
            System.out.printf("Case #%d: %d\n", test + 1, answer);
        }
        br.close();
    }
}
