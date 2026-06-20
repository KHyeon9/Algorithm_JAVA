import java.io.*;
import java.util.*;

class BestInspection {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] posArr = new int[3][2];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            posArr[i][0] = Integer.parseInt(st.nextToken());
            posArr[i][1] = Integer.parseInt(st.nextToken());
        }
        // 기울기 구하기
        int dx1 = posArr[1][0] - posArr[0][0];
        int dy1 = posArr[1][1] - posArr[0][1];
        int dx2 = posArr[2][0] - posArr[1][0];
        int dy2 = posArr[2][1] - posArr[1][1];
        // 기울기가 같으면 YES
        System.out.println(dy1 * dx2 == dy2 * dx1 ? "YES" : "NO");
    }
}