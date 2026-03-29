import java.io.*;
import java.util.*;

public class BOJ27496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] drinks = new int[n];
        int bac = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            // 일정 갯수 관리를 위한 배열에 저장
            drinks[i] = Integer.parseInt(st.nextToken());
            // 혈중 알코올 농도 추가
            bac += drinks[i];
            // 갯수를 넘으면 맨 처음 더한 값 빼주기
            if (i >= l) {
                bac -= drinks[i - l];
            }
            // 원하는 알코올 농도 범위 내이면 결과 증가
            if (129 <= bac && bac <= 138) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
