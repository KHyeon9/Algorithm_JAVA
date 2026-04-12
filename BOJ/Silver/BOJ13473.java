import java.io.*;
import java.util.*;

public class BOJ13473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        if (x1 != x2) {
            System.out.printf("%d %d %d %d", x1, 0, x2, h);
        } else {
            System.out.printf("%d %d %d %d", 0, y1, w, y2);
        }
    }
}
