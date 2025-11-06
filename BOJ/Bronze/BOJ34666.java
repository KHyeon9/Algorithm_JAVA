import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ34666 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            int language = Integer.parseInt(st.nextToken());
            int reading = Integer.parseInt(st.nextToken());
            int listening = Integer.parseInt(st.nextToken());

            System.out.println(
                    isInterested(level, language, reading, listening)
                    ? "YES"
                    : "NO"
            );
        }
    }

    public static boolean isInterested(int lv, int lang, int read, int listen) {
        // 1 ~ 2급이 아니면 관심없음
        if (lv != 1 && lv != 2) return false;
        // 청해가 50점 이하면 관심없음
        if (listen < 50) return false;

        int[] inputInfo = {lang, read};
        int sumMin = lv == 1 ? 100 : 90;
        int cnt1 = 0;
        int cnt2 = 0;

        for (int score : inputInfo) {
            // 해당 영역의 점수에 3을 곱한 값보다
            // 응시한 급수의 총점 최소 합격 점수가 더 높으면 +1
            if (score * 3 < sumMin) cnt1++;
            // 해당 영역에서 과락을 받지 않는 최소 점수보다 
            // 3점 이상 높지 않습니다.
            if (score <= 21) cnt2++;
        }
        // 둘중 1개만 충족하면 관심 있음
        return cnt1 >= 2 || cnt2 >= 1;
    }
}
