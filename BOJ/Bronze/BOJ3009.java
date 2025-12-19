import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] xArr = new int[3];
        int[] yArr = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xArr[i] = x;
            yArr[i] = y;
        }

        System.out.println(solution(xArr) + " " + solution(yArr));
    }

    private static int solution(int[] arr) {
        if (arr[0] == arr[1]) return arr[2];
        return arr[1] == arr[2] ? arr[0] : arr[1];
    }
}
