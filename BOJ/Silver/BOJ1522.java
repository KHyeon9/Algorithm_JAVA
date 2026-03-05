import java.util.*;

public class BOJ1522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        // 역순도 확인해야 하므로 2배로 길이 늘려 저장
        int aCnt = 0;
        int length = str.length();
        char[] chars = new char[length * 2];
        for (int i = 0; i < length; i++) {
            char now = str.charAt(i);
            aCnt += now == 'a' ? 1 : 0;
            chars[i] = now;
            chars[i + length] = now;
        }
        // a의 갯수만큼 뭉쳐야 하므로 해당 범위안에 b의 갯수의 최소값이 정답
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int bCnt = 0;
            for (int j = 0; j < aCnt; j++) {
                bCnt += chars[i + j] == 'b' ? 1 : 0;
            }
            answer = Math.min(answer, bCnt);
        }
        System.out.println(answer);
        sc.close();
    }
}
