import java.io.*;
import java.util.*;

public class BOJ6603 {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            // 탈출 조건
            if (cnt == 0) {
                break;
            }
            // visited 셋팅
            visited = new boolean[cnt + 1];
            // 번호 저장
            int[] nums = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            // 출력
            Deque<Integer> answer = new ArrayDeque<>();
            printRottoNums(answer, 0, nums, cnt);
            System.out.println();
        }
    }

    private static void printRottoNums(Deque<Integer> storeNums, int idx, int[] nums, int cnt) {
        // 사이즈가 로또 번호 갯수와 같으면 출력
        if (storeNums.size() == 6) {
            StringBuilder sb = new StringBuilder();
            for (int num : storeNums) {
                sb.append(num).append(" ");
            }
            System.out.println(sb);
            return;
        }
        // 탐색
        for (int next = idx; next < cnt; next++) {
            // 방문하지 않은 경우 백트랙킹
            if (!visited[next]) {
                visited[next] = true;
                storeNums.addLast(nums[next]);
                printRottoNums(storeNums, next, nums, cnt);
                storeNums.pollLast();
                visited[next] = false;
            }
        }
    }
}
