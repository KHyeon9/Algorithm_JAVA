import java.util.*;

public class BOJ1417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int myVote = sc.nextInt();
        // 우선순위 큐로 나보다 큰 투표수를 찾기위해 저장 
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < cnt - 1; i++) {
            pq.add(sc.nextInt());
        }
        // 매수 횟수 구하기
        int answer = 0;
        while (!pq.isEmpty() && pq.peek() >= myVote) {
            // 현재 최대 투표수 추출 및 매수
            int otherVote = pq.poll() - 1;
            pq.add(otherVote);
            // 매수한 표 더하기
            myVote++;
            answer++;
        }
        System.out.println(answer);
    }
}
