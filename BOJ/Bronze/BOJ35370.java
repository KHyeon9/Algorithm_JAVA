import java.io.*;
import java.util.*;

public class BOJ35370 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        System.out.println(getCnt(k, s));
        br.close();
    }

    private static int getCnt(int k, int s) {
        return (s / k) + (s % k);
    }
}
