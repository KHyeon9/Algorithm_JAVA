import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11650 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] xyArr = new int [n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                xyArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 첫 원소가 같은 경우 두번째 원소를 비교해 오름 차순
        Arrays.sort(xyArr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for (int[] xy : xyArr) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 2; i++) {
                sb.append(xy[i] + " ");
            }

            System.out.println(sb);
        }
    }
}
