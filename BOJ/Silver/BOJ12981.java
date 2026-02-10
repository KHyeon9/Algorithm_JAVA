import java.io.*;
import java.util.*;

public class BOJ12981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rCnt = Integer.parseInt(st.nextToken());
        int gCnt = Integer.parseInt(st.nextToken());
        int bCnt = Integer.parseInt(st.nextToken());
        // 3개의 색 모두 다 넣은 경우
        int diffBoxCnt = Math.min(rCnt, Math.min(gCnt, bCnt));
        // 위의 수가 빠진 총 갯수
        rCnt -= diffBoxCnt;
        gCnt -= diffBoxCnt;
        bCnt -= diffBoxCnt;
        // 3개씩 넣은 박스 총 갯수
        int total = diffBoxCnt + rCnt / 3 + gCnt / 3 + bCnt / 3;
        // 나머지 계산을 위한 계산
        rCnt %= 3;
        gCnt %= 3;
        bCnt %= 3;
        // 나머지 필요한 박스 구하기
        int remain = 0;
        int sum = rCnt + gCnt + bCnt;
        if (sum > 0) {
            remain = 1;
        }
        if (sum >= 3) {
            remain = 2;
        }
        System.out.println(total + remain);
    }
}
