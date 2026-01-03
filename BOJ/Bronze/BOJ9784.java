import java.util.*;
import java.io.*;

public class BOJ9784 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            // 총 계란 셋팅
            int[] eggs = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i <n; i++) {
                eggs[i] = Integer.parseInt(st.nextToken());
            }
            // 정렬
            Arrays.sort(eggs);
            // 전체 계란 무게
            int sumWeight = 0;
            int eggCnt = 0;
            for (int eggWeight : eggs) {
                if (sumWeight + eggWeight > q) {
                    break;
                }
                eggCnt++;
                sumWeight += eggWeight;
            }
            System.out.println(String.format("Case %d: %d", t + 1, Math.min(eggCnt, p)));
        }
    }
}
