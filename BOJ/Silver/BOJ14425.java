import java.io.*;
import java.util.*;

public class BOJ14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int setLen = Integer.parseInt(st.nextToken());
        int searchCnt = Integer.parseInt(st.nextToken());

        Set<String> strSet = new HashSet<>();
        for (int i = 0; i < setLen; i++) {
            strSet.add(br.readLine());
        }

        int answer = 0;
        // 집합에 포함되는지 확인
        for (int i = 0; i < searchCnt; i++) {
            String searchStr = br.readLine();
            if (strSet.contains(searchStr)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
