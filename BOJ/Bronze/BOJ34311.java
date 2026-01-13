import java.io.*;
import java.util.*;

public class BOJ34311 {
    static Map<Character, Character> keyboardMap = new HashMap<>();
    static {
        // a에서 z를 키보드 순서대로  map저장
        char[] beforeKeyboard =
                "qwertyuiopasdfghjklzxcvbnm"
                .toCharArray();

        for (int i = 0; i < 26; i++) {
            char change = (char) ('a' + i);
            keyboardMap.put(change, beforeKeyboard[i]);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        // 변환 및 출력
        String beforeLine = br.readLine();
        StringBuilder answer = new StringBuilder();
        for (char beforeCh : beforeLine.toCharArray()) {
            if (keyboardMap.containsKey(beforeCh)) {
                answer.append(keyboardMap.get(beforeCh));
            } else {
                answer.append(beforeCh);
            }
        }
        System.out.println(answer);
    }
}
