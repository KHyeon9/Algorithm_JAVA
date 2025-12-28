import java.io.*;
import java.util.*;

public class BOJ2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] answer = new int[t];
        // 풍선들 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Balloon> balloons = new ArrayDeque<>();
        for (int i = 1; i <= t; i++) {
            int val = Integer.parseInt(st.nextToken());
            Balloon balloon = new Balloon(i, val);
            balloons.addLast(balloon);
        }
        // 로직 시작
        int arrIdx = 0;
        while (true) {
            Balloon temp = balloons.pollFirst();
            answer[arrIdx++] = temp.idx;
            if (balloons.isEmpty()) {
                break;
            }
            int move = temp.value;
            if (move > 0) {
                // 풍선에서 나온값이 양수인 경우
                // 앞에서 꺼낸뒤 값을 구하므로 -1 만큼
                for (int i = 0; i < move - 1; i++) {
                    // 앞에서 꺼내서 뒤에 넣기
                    balloons.addLast(balloons.pollFirst());
                }
            } else {
                // 풍선에서 나온값이 음수인 경우
                for (int i = 0; i < Math.abs(move); i++) {
                    // 뒤에서 꺼내서 앞에 넣기
                    balloons.addFirst(balloons.pollLast());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n : answer) sb.append(n).append(" ");
        System.out.println(sb);
    }

    private static class Balloon {
        int idx;
        int value;

        public Balloon(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
