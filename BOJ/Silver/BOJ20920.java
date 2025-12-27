import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 중복 제거로 값 받기
        Map<String, Integer> wordsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            // 문자열의 길이가 m이상일 경우에만 저장
            if (word.length() >= m) {
                wordsMap.put(
                        word,
                        wordsMap.getOrDefault(
                                word,
                                0
                        ) + 1
                );
            }
        }
        // 정렬하기 위한 키셋 리스트
        List<String> wordsList = new ArrayList<>(wordsMap.keySet());
        Collections.sort(wordsList, (o1, o2) -> {
            // 등장 갯수에 따른 정렬
            int cntGap = wordsMap.get(o2).compareTo(wordsMap.get(o1));
            if (cntGap != 0) {
                return cntGap;
            }
            // 문자열 길이에 따른 정렬
            int lenGap = o2.length() - o1.length();
            if (lenGap != 0) {
                return lenGap;
            }
            // 두 조건이 아닌 경우 사전순 정렬
            return o1.compareTo(o2);
        });
        // 출력
        StringBuilder answer = new StringBuilder();
        for (String word : wordsList) {
            answer.append(word).append("\n");
        }
        System.out.println(answer);
    }
}
