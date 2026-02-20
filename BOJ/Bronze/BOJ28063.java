import java.io.*;
import java.util.*;

public class BOJ28063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        System.out.println(getCount(x, y, size));
    }

    private static int getCount(int x, int y, int size) {
        int cnt = 4;
        if (x == 1) cnt--;
        if (x == size) cnt--;
        if (y == 1) cnt--;
        if (y == size) cnt--;

        return cnt;
    }
}
