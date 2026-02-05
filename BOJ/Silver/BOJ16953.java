import java.io.*;
import java.util.*;

public class BOJ16953 {
    static class CalcInfo {
        // int형을 벗어나는 경우가 있으므로 long형
        long num;
        int cnt;

        public CalcInfo(long num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        System.out.println(getCalcCnt(start, target));
    }

    private static int getCalcCnt(int start, int target) {
        Deque<CalcInfo> deq = new ArrayDeque<>();
        CalcInfo calcStart = new CalcInfo(start, 1);
        deq.addLast(calcStart);

        while (!deq.isEmpty()) {
            CalcInfo now = deq.pollFirst();
            // 타겟이랑 같으면 연산 횟수 반환
            if (now.num == target) {
                return now.cnt;
            }
            // 다음 숫자 탐색
            long[] nextNums = {now.num * 2, now.num * 10 + 1};
            for (int i = 0; i < 2; i++) {
                // 크기가 작은 경우에만 덱에 저장
                if (nextNums[i] <= target) {
                    CalcInfo nextCalc =
                            new CalcInfo(nextNums[i], now.cnt + 1);
                    deq.addLast(nextCalc);
                }
            }
        }
        return -1;
    }
}
