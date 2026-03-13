import java.io.*;
import java.util.*;

public class BOJ1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        Set<Character> checkSet = new HashSet<>();
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<String> words = new ArrayList<>();
            while (st.hasMoreTokens()) {
                words.add(st.nextToken());
            }
            int targetWordIdx = -1;
            int targetCharIdx = -1;
            // 첫 글자가 단축키가 되는지 확인
            for (int j = 0; j < words.size(); j++) {
                char now = Character.toLowerCase(words.get(j).charAt(0));
                if (!checkSet.contains(now)) {
                    checkSet.add(now);
                    targetWordIdx = j;
                    targetCharIdx = 0;
                    break;
                }
            }
            // 첫글자 모두 단축키가 안되면 검사
            if (targetWordIdx == -1) {
                for (int j = 0; j < words.size(); j++) {
                    String word = words.get(j);
                    for (int k = 0; k < word.length(); k++) {
                        char now = Character.toLowerCase(word.charAt(k));
                        // 왼쪽부터 검사해 단축키 가능한지 검사
                        if (!checkSet.contains(now)) {
                            checkSet.add(now);
                            targetWordIdx = j;
                            targetCharIdx = k;
                            break;
                        }
                    }
                    // 단축키 찾았으면 탈출
                    if (targetWordIdx != -1) {
                        break;
                    }
                }
            }
            // 계산한 index를 기준으로 만들어 출력
            StringBuilder answer = new StringBuilder();
            for (int j = 0; j < words.size(); j++) {
                String word = words.get(j);
                for (int k = 0; k < word.length(); k++) {
                    char ch = word.charAt(k);
                    if (targetWordIdx == j && targetCharIdx == k) {
                        answer.append("[").append(ch).append("]");
                    } else {
                        answer.append(ch);
                    }
                }
                answer.append(" ");
            }
            System.out.println(answer);
        }
        br.close();
    }
}
