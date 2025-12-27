import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 배열 초기화
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int now = 1, idx = 0;
        // idx가 n보다 작은 경우 반복
        while (idx < n) {
            if (nums[idx] == now) {
                // 현재 값과 idx가 가리키는 값이 같은 경우
                idx++;
                now++;
            } else {
                // idx가 가리키는 값과 now가 다른 경우 
                if (!dq.isEmpty() && now == dq.peek()) {
                    // 스택이 비어있지 않고
                    // 맨뒤의 값과 now가 같은 경우
                    dq.pop();
                    now++;
                } else {
                    // 스택이 비어있거나 마지막 값과 다른 경우
                    dq.push(nums[idx]);
                    idx++;
                }
            }
        }
        // 스택에 남은 값 계산
        while (!dq.isEmpty() && now == dq.peek()) {
            dq.pop();
            now++;
        }
        System.out.println(dq.isEmpty() ? "Nice" : "Sad");
    }
}
