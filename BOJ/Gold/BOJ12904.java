import java.io.*;

public class BOJ12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();
        // 만들수 있는지 체크
        boolean isMade = false;
        StringBuilder now = new StringBuilder(t);
        // now가 비어있지 않으면 반복
        while (now.length() > 0) {
            // 같으면 만들수 있음 체크하고 탈출
            if (now.toString().equals(s)) {
                isMade = true;
                break;
            }
            // 마지막 단어 체크릴 위한 셋팅
            int last = now.length() - 1;
            boolean isReverse = now.charAt(last) == 'B';
            // 마지막 값을 제거
            now.delete(last, last + 1);
            // 만약 마지막 값이 B였으면 뒤집기
            if (isReverse) {
                now.reverse();
            }
        }
        // 출력
        System.out.println(isMade ? 1 : 0);
    }
}
