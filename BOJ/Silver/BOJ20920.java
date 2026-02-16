import java.io.*;
import java.util.*;

public class BOJ20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int wordCnt = Integer.parseInt(st.nextToken());
        int standardLength = Integer.parseInt(st.nextToken());
        // 입력 단어가 길이 이상인 겨우 총 갯수와 같이 저장
        Map<String, Integer> wordAndCnt = new HashMap<>();
        for (int i = 0; i < wordCnt; i++) {
            String word = br.readLine();
            if (word.length() >= standardLength) {
                wordAndCnt.put(
                        word,
                        wordAndCnt.getOrDefault(word, 0) + 1
                );
            }
        }
        // 정렬
        List<String> wordSort = new ArrayList<>(wordAndCnt.keySet());
        wordSort.sort((o1, o2) -> {
            // 자주 나오는 단어 순
            if (!wordAndCnt.get(o2).equals(wordAndCnt.get(o1))) {
                return wordAndCnt.get(o2) - wordAndCnt.get(o1);
            }
            // 단어의 길이가 긴 순
            if (o2.length() != o1.length()) {
                return o2.length() - o1.length();
            }
            // 알파벳 사전 순
            return o1.compareTo(o2);
        });
        // 출력
        StringBuilder answer = new StringBuilder();
        for (String word : wordSort) {
            answer.append(word).append("\n");
        }
        System.out.println(answer);
    }

}
