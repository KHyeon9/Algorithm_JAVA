import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ34758 {
    static int targetX;
    static int targetY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        targetX =  Integer.parseInt(st.nextToken());
        targetY =  Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            System.out.println(check(x, y));
        }
    }
    // 목표 위치로 가는데 x, y중 하나라도 일치하면 1
    private static int check(int x, int y) {
        return (x == targetX || y == targetY) ? 0 : 1;
    }
}
