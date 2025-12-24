import java.util.*;
import java.io.*;

public class BOJ10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> numMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            // num이 있으면 값을 가져와서 1 더하고 아니면 1로 반환
            int cnt = numMap.getOrDefault(num, 0) + 1;
            numMap.put(num, cnt);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int checkNum = Integer.parseInt(st.nextToken());
            // 키가 없으면 0반환 있으면 value 반환
            int numCnt = numMap.getOrDefault(checkNum, 0) ;
            answer.append(numCnt).append(" ");

        }

        System.out.println(answer);
        br.close();
    }
}
