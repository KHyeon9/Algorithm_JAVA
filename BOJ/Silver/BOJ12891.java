import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int[] acgt_need_cnt = new int[4];
        char[] str = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        // acgt 필요 갯수 받기
        for (int i = 0; i < 4; i++) {
            acgt_need_cnt[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 비밀번호 후보 알바벳 카운트
        int[] now_acgt_cnt = new int[4];
        for (int i = 0; i < p; i++) {
            now_acgt_cnt[position(str[i])]++;
        }

        // 슬라이딩 윈도우 로직
        for (int i = 0; i <= s - p; i++) {
            boolean flag = true;
            for (int j = 0; j < 4; j++) {
                // 알파벳 갯수가 다르면 flag false
                if (now_acgt_cnt[j] < acgt_need_cnt[j]) {
                    flag = false;
                }
            }
            // 알파벳 갯수가 다 맞으면 +1
            if (flag) cnt++;
            // 마지막이면 값을 문자열 변경 오류 방지
            if (i == s - p) break;
            // 한칸 이동으로 첫글자 빼고 마지막 글자 추가
            now_acgt_cnt[position(str[i])]--;
            now_acgt_cnt[position(str[i + p])]++;
        }
        System.out.println(cnt);
    }
    // 문자의 값에 따른 위치 반환
    private static int position(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return -1;
    }
}
