import java.io.*;
import java.util.*;

public class BOJ21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int viewCnt = Integer.parseInt(st.nextToken());
        int days = Integer.parseInt(st.nextToken());
        // 누적합 셋팅
        st = new StringTokenizer(br.readLine());
        int[] views = new int[viewCnt + 1];
        int sum = 0;
        for (int i = 1; i <= viewCnt; i++) {
            sum += Integer.parseInt(st.nextToken());
            views[i] = sum;
        }
        // 최대 조회수 구하기
        int maxView = 0, equalCnt = 0;
        for (int i = days; i <= viewCnt; i++) {
            int nowView = views[i] - views[i - days];
            // 최대 조회수와 같으면 cnt 증가
            if (maxView == nowView) {
                equalCnt++;
            }
            // 최대 조회수가 바뀌면 max값 셋팅 및 초기화
            if (maxView < nowView) {
                maxView = nowView;
                equalCnt = 1;
            }
        }
        // 출력
        if (maxView == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxView);
            System.out.println(equalCnt);
        }
    }
}
