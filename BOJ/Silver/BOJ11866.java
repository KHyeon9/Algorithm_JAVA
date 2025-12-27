import java.util.*;

public class BOJ11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<String> dq = new ArrayDeque<>();

        int n = sc.nextInt();
        int k = sc.nextInt();
        // nums 초기화
        String[] nums = new String[n];
        for (int i = 1; i <= n; i++) {
            dq.add(String.valueOf(i));
        }
        // 덱의 empty시 탈출 및 필요변수 선언
        int idx = 0, cnt = 0;
        while (!dq.isEmpty()) {
            cnt++;
            if (cnt == k) {
                // cnt가 k랑 같은 경우 맨앞 nums에 넣고 idx++
                nums[idx++] = dq.poll();
                // cnt = 0으로 초가화
                cnt = 0;
            } else {
                // cnt가 3이 아닌경우 앞의 수를 뒤로 이동
                String temp = dq.poll();
                dq.add(temp);
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append("<")
                .append(String.join(", ", nums))
                .append(">");
        System.out.println(answer);
    }
}
