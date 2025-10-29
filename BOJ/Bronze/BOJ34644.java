import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ34644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] order = new int[101];
        for (int i = 1; i <= 100; i++) {
            int num = Integer.parseInt(st.nextToken());
            order[num] = i;
        }

        int lastPlayer = -1;
        int lastCall = -1;

        for (int p = 1; p <= 10; p++) {
            int bingoTime = 0;
            // 100 개의 숫자가 불리므로 각 인원에 맞는 숫자 확인
            // 확인한 숫자의 마지막으로 불리는 숫자의 순서 확인
            for (int num = p; num <= 100; num += 10) {
                bingoTime = Math.max(bingoTime, order[num]);
            }
            // 각 플레이어의 마지막으로 불린 시간으로 결과 계산 
            if (bingoTime > lastCall) {
                lastCall = bingoTime;
                lastPlayer = p;
            }
        }

        System.out.println(lastPlayer);
    }
}
