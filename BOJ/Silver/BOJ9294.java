import java.io.*;
import java.util.*;

public class BOJ9294 {
    static Deque<Integer> deq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int diceCnt = Integer.parseInt(st.nextToken());
            int maxNum = Integer.parseInt(st.nextToken());
            int targetNum = Integer.parseInt(st.nextToken());

            System.out.printf("Case %d:\n", test + 1);
            getDiceNums(targetNum, diceCnt, maxNum, 0, 0, 1);
        }
    }
    // 모든 주사위 숫자들 구하기
    private static void getDiceNums(
            int target,
            int diceCnt,
            int maxNum,
            int sum,
            int cnt,
            int lastNum
    ) {
        // 타겟 이상인 경우
        if (cnt == diceCnt) {
            // 타겟과 같으면 출력
            if (sum == target) {
                // 편하게 중간 ,나 ()를 넣기위해 StringJoiner
                StringJoiner sj = new StringJoiner(",", "(", ")");
                for (int num : deq) {
                    sj.add("" + num);
                }
                System.out.println(sj);
            }
            return;
        }
        
        for (int now = lastNum; now <= maxNum; now++) {
            // 현재값과 저장된 합 이하인 경우
            if (sum + now <= target) {
                // 백트래킹
                deq.add(now);
                getDiceNums(target, diceCnt, maxNum, sum + now, cnt + 1, now);
                deq.pollLast();
            }
        }
    }
}
