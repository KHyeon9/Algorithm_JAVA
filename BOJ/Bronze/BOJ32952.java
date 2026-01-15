import java.io.*;
import java.util.*;

public class BOJ32952 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long r = Long.parseLong(st.nextToken());
        double k = Double.parseDouble(st.nextToken());
        double m = Double.parseDouble(st.nextToken());

        long count = (long) (m / k);
        // 2의 62승이 넘으면 long의 범위를 넘어가서 0
        if (count > 62) {
            System.out.println(0);
        } else {
            while (count > 0) {
                r /= 2;
                count--;
            }
            System.out.println(r);
        }
    }
}
