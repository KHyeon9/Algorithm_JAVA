import java.io.*;
import java.util.*;

public class BOJ24035 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        Map<Integer, Integer> sizeCntMap = new HashMap<>();

        for (int test = 1; test <= testCase; test++) {
            int cnt = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            // 오름차순 정렬 set
            Set<Integer> sizeSet = new TreeSet<>(Comparator.naturalOrder());
            for (int i = 0; i < cnt; i++) {
                int size = Integer.parseInt(st.nextToken());
                sizeSet.add(size);
                // 갯수 저장
                sizeCntMap.put(
                        size,
                        sizeCntMap.getOrDefault(
                                size, 0) + 1
                );
            }
            int snackCnt = 1, answer = 0;
            // 크기 순서대로 간식 갯수를 1개씩 올리며 지급
            for (int size : sizeSet) {
                answer += sizeCntMap.get(size) * snackCnt;
                snackCnt++;
            }
            System.out.printf("Case #%d: %d%n", test, answer);
            sizeCntMap.clear();
        }
        br.close();
    }
}
