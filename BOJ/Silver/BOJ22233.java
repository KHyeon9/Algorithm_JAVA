import java.io.*;
import java.util.*;

public class BOJ22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int memoCnt = Integer.parseInt(st.nextToken());
        int keywordCnt = Integer.parseInt(st.nextToken());
        // 메모에 키워드 적기
        Set<String> memo = new HashSet<>();
        for (int i = 0; i < memoCnt; i++) {
            memo.add(br.readLine());
        }
        // 주어진 키워드 확인 및 제거
        for (int i = 0; i < keywordCnt; i++) {
            String[] keywords = br.readLine().split(",");

            for (String keyword : keywords) {
                if (memo.contains(keyword)) {
                    memo.remove(keyword);
                }
            }
            System.out.println(memo.size());
        }
        br.close();
    }
}
