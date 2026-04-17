import java.io.*;
import java.util.*;

public class BOJ17509 {
    static class SolveInfo {
        int time, wrongCnt;

        public SolveInfo(int time, int wrongCnt) {
            this.time = time;
            this.wrongCnt = wrongCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        SolveInfo[] solveList = new SolveInfo[11];
        for (int i = 0; i < 11; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int wrongCnt = Integer.parseInt(st.nextToken());
            solveList[i] = new SolveInfo(time, wrongCnt);
        }
        br.close();
        // 적은 시간 순으로 정렬
        Arrays.sort(solveList, Comparator.comparing(o -> o.time));
        // 계산
        int answer = 0, nowTime = 0;
        for (SolveInfo info : solveList) {
            nowTime += info.time;
            // 계산식에 따른 결과 더하기
            answer += nowTime + (20 * info.wrongCnt);
        }
        System.out.println(answer);
    }
}
