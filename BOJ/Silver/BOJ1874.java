import java.util.*;

public class BOJ1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num;
        int now = 1;
        // stack을 deque로 구현
        Deque<Integer> stack = new ArrayDeque<>();
        // 결과 저장할 리스트
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            // now가 num이랑 같을 때까지 값 저장 및 "+" 저장
            while (num >= now) {
                stack.push(now++);
                answer.add("+");
            }
            // 만약 num과 stack의 peek가 같다면 "-" 저장 및 pop
            if (num == stack.peek()) {
                stack.pop();
                answer.add("-");
            }
        }
        // stack이 안비워지면 불가능
        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            // stack이 비워졌으면 출력
            for (String s : answer) {
                System.out.println(s);
            }
        }
    }
}
