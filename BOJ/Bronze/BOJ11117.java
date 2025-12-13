import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ11117 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            String alpaList = sc.next();
            int w = sc.nextInt();
            // 현재 주어진 알파뱃 갯수 구하기
            Map<Character, Integer> alpaMap = new HashMap<>();
            for (char c : alpaList.toCharArray()) {
                alpaMap.put(c, alpaMap.getOrDefault(c, 0) + 1);
            }
            
            for (int j = 0; j < w; j++) {
                String line = sc.next();
                // 단어마다 갯수 초기화
                Map<Character, Integer> tempMap = new HashMap<>(alpaMap);
                boolean flag = true;

                for (char c : line.toCharArray()) {
                    // 해당 알파벳이 존재하고 0보다 큰경우 
                    if (tempMap.containsKey(c) && tempMap.get(c) > 0) {
                        tempMap.put(c, tempMap.get(c) - 1);
                    } else {
                        flag = false;
                        break;
                    }
                }

                System.out.println(flag ? "YES" : "NO");
            }
        }
    }
}
