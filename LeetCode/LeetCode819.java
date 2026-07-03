import java.util.*;

public class LeetCode819 {
    // Most Common Word
    public String mostCommonWord(String paragraph, String[] banned) {
        // 소문자로 변환 후 특수 문자 제거 및 split
        String[] convParagraph = paragraph
                .toLowerCase().replaceAll("[^a-z]", "").split("\\s+");
        // 금지 단어를 빠르게 차지 위한 set 셋팅
        Set<String> banSet = new HashSet<>();
        for (String banWord : banned) banSet.add(banWord);
        // 문자의 갯수를 저장하기 위한 map
        Map<String, Integer> wordCntMap = new HashMap<>();
        // 각 단어를 검사
        for (String word : convParagraph) {
            // 금지 단어 넘어가기
            if (banSet.contains(word)) continue;
            // 값이 있으면 +1 없으면 1로 넣기
            wordCntMap.put(word, wordCntMap.getOrDefault(word, 0) + 1);
        }
        // 최대 출현 단어 찾기
        String answer = "";
        int maxCnt = 0;
        for (String word : wordCntMap.keySet()) {
            if (maxCnt < wordCntMap.get(word)) {
                maxCnt = wordCntMap.get(word);
                answer = word;
            }
        }
        return answer;
    }
}
