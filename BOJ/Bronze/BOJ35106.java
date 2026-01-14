import java.io.*;
import java.util.*;

public class BOJ35106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> rspCnt = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 필요 갯수 이상의 손동작 찾기
        int answer1 = -1;
        for (int i = 0; i < n * 3; i++) {
            int now = Integer.parseInt(st.nextToken());
            int find = rspCnt.getOrDefault(now, 0);

            if (find == n && answer1 == -1) {
                answer1 = now;
            }

            rspCnt.put(now , find + 1);
        }
        // 미달한 갯수인 손동작 찾기
        int answer2 = -1;
        for (int key = 1; key <= 3; key++) {
            if (rspCnt.getOrDefault(key, 0) < n) {
                answer2 = key;
                break;
            }
        }
        System.out.println(answer2);
        System.out.println(answer1);
    }
}
