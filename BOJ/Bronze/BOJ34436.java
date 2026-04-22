import java.io.*;
import java.util.*;

public class BOJ34436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < cnt; i++) {
            // 입력 받은 문자열을 나눠서 갯수로 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                char firstCh = st.nextToken().charAt(0);
                charMap.put(
                        firstCh, 
                        charMap.getOrDefault(firstCh, 0) + 1
                );
            }
            // 가장 많이 등장하고 같은 수가 있는 경우 
            // 사전순으로 출력
            List<Character> charList = new ArrayList<>(charMap.keySet());
            charList.sort((o1, o2) -> {
                if (charMap.get(o1) != charMap.get(o2)) {
                    return charMap.get(o2) - charMap.get(o1);
                }
                return o1.compareTo(o2);
            });
            System.out.println(charList.get(0));
            charMap.clear();
        }
    }
}
