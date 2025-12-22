import java.io.*;
import java.util.*;

public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] pointOrigin = new int[n];

        for (int i = 0; i < n; i++) {
            pointOrigin[i] = Integer.parseInt(st.nextToken());
        }
        // 복사 및 정렬
        int[] sortedPoints = pointOrigin.clone();
        Arrays.sort(sortedPoints);
        // 맵을 통해 key, value로 저장
        Map<Integer, Integer> sortedIndexMap = new HashMap<>();
        int nowIndex = 0;
        for (int val : sortedPoints) {
            if(!sortedIndexMap.containsKey(val)) {
                sortedIndexMap.put(val, nowIndex);
                nowIndex++;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int point : pointOrigin) {
            // 배열의 원소가 정렬된 위치의 어디에 있는지 찾기
            answer.append(sortedIndexMap.get(point))
                    .append(" ");
        }

        System.out.println(answer);
    }
}
