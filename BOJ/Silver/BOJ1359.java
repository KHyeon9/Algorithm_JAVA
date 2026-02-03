import java.io.*;
import java.util.*;

public class BOJ1359 {
    static ArrayList<int[]> numsList;
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        numsList = new ArrayList<>();
        DFS(1, n, m);
        // 아무 조합이 당첨인 경우 당첨 확률 계산
        double currCnt = 1;
        int[] currNums = numsList.get(0);
        for (int i = 1; i < numsList.size(); i++) {
            if (isJackpot(currNums, numsList.get(i), k)) {
                currCnt++;
            }
        }
        System.out.println(String.format("%.9f", currCnt / numsList.size()));
    }
    // 당첨인지 확인
    private static boolean isJackpot(int[] currNums, int[] nums, int targetCnt) {
        int cnt = 0;
        int len = currNums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (currNums[i] == nums[j]) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt >= targetCnt;
    }
    // 조합 찾기
    private static void DFS(int start, int max, int size) {
        if (deque.size() == size) {
            int[] nums = new int[size];
            int idx = 0;
            for (int num : deque) {
                nums[idx++] = num;
            }
            numsList.add(nums);
            return;
        }

        for (int i = start; i <= max; i++) {
            deque.addLast(i);
            DFS(i + 1, max, size);
            deque.pollLast();
        }
    }
}
