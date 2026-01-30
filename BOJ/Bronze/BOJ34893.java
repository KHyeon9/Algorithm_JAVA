import java.io.*;
import java.util.*;

public class BOJ34893 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long uCnt = Long.parseLong(st.nextToken());
        long oCnt = Long.parseLong(st.nextToken());
        long sCnt = Long.parseLong(st.nextToken());

        long answer = -1;
        long left = 0, right = oCnt;
        while (left <= right) {
            // mid가 현제 oCnt 갯수
            long mid = (left + right) / 2;
            if (isMade(uCnt, sCnt, mid)) {
                // 만들 수 있으면 더 큰 값이 될수도 있으므로 left를 mid + 1로 변경
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                // 만들 수가 없으므로 right를 mid - 1로 변경
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean isMade (long uCnt, long sCnt, long oCnt) {
        return (
                // o의 갯수보다 u의 갯수 이상인 경우
                uCnt >= oCnt && 
                (
                    // s의 갯수가 o의 갯수 이상이거나
                    sCnt >= oCnt ||
                    // u의 남은 갯수로 s로 변환해 더한 값이 o의 갯수 이상인 경우 만들 수 있음
                    sCnt + (uCnt - oCnt) / 2 >= oCnt 
                )
        );
        
    }
}
