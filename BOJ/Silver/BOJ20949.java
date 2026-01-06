import java.util.*;
import java.io.*;

public class BOJ20949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] ppiAndIdxArray = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int ppi = w * w + h * h;
            ppiAndIdxArray[i] = new int[] { ppi, i };
        }

        Arrays.sort(ppiAndIdxArray, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o1[1];
            }
            return o2[0] - o1[0];
        });
        for (int[] ppiAndIds : ppiAndIdxArray) {
            System.out.println(ppiAndIds[1] + 1);
        }
    }
}
