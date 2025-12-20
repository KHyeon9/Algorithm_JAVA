import java.util.Scanner;

public class BOJ1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int[] alpaCnt = new int[26];
        // 사용 알파벳 세기
        for (char c : str.toCharArray()) {
            alpaCnt[Character.toUpperCase(c) - 'A']++;
        }

        char maxUse = 0;
        int maxCnt = 0;
        boolean flag = true;

        for (int i = 0; i < 26; i++) {
            // 사용하지 않은 알파벳 패스
            if (alpaCnt[i] == 0) continue;
            if (maxCnt <= alpaCnt[i]) {
                if (maxCnt == alpaCnt[i]) {
                    // 같은 갯수의 알파벳이 최대 갯수이면 flag false
                    flag = false;
                } else {
                    // 이전보다 많이 사용한 알파벳이면 
                    // flag 초기화 및 결과 변경
                    flag =  true;
                    maxCnt = alpaCnt[i] ;
                    maxUse = (char) ('A' + i);
                }
            }
        }
        System.out.println(flag ? maxUse : "?");
    }
}
