import java.io.*;
import java.util.*;

public class BOJ11003 {
    static class NumIndex {
        int val, idx;

        public NumIndex(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // 단조 큐 시작
        StringBuilder answer = new StringBuilder();
        Deque<NumIndex> deq = new ArrayDeque<>();
        for (int index = 0; index < cnt; index++) {
            int nowNum = nums[index];
            // 현재값보다 덱의 마지막 값이 큰 것들 모두 제거
            while (!deq.isEmpty() && deq.peekLast().val > nowNum) {
                deq.pollLast();
            }
            // 현재 값 넣기
            deq.addLast(new NumIndex(nowNum, index));
            // 해당 값의 index가 범위안에 있지 않으면 삭제
            if (!deq.isEmpty() && deq.peekFirst().idx <= index - len) {
                deq.pollFirst();
            }
            answer.append(deq.peekFirst().val + " ");
        }
        System.out.println(answer);
    }
}
