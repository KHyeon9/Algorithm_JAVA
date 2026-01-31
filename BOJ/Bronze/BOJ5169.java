import java.io.*;
import java.util.*;

public class BOJ5169 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());

        for (int test = 1; test <= testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int[] buyAmount = new int[s + 1];

            for (int i = 0; i < t; i++) {
                st = new StringTokenizer(br.readLine());
                int si = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                buyAmount[si] += p;
            }
            int answer = -1;
            for (int target = 1; target <= s; target++) {
                boolean isOk = true;
                for (int other = 1; other <= s; other++) {
                    if (target != other) {
                        if (buyAmount[target] <= buyAmount[other] * 2) {
                            isOk = false;
                            break;
                        }
                    }
                }
                if (isOk) {
                    answer = target;
                    break;
                }
            }
            System.out.printf("Data Set %d:\n", test);
            System.out.println(answer == -1 ? "No suspect." : answer);
            if (test < testCase) System.out.println();
        }

        br.close();
    }
}
