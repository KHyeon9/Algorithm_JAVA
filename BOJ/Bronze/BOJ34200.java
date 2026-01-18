import java.io.*;
import java.util.*;

public class BOJ34200 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        // 결과 값과 현재 위치 저장을 위한 변수
        int answer = 0, now = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int hurdle = Integer.parseInt(st.nextToken());
            // 장애물 넘은 자리에 장애물이 있으면 불가능
            if (now == hurdle) {
                answer = -1;
                break;
            }
            // 허들 전까지의 거리
            int beforeHurdle = hurdle - 1;
            // 현재 위치에서 허들 전까지 거리 계산
            int length = beforeHurdle - now;
            // 최대한 점프하고 남은 거리만 걷기
            answer += length / 2 + length % 2;
            // 허들 넘기
            answer++;
            // 현재 위치를 허들 넘은 위치로 변경
            now = hurdle + 1;
        }
        System.out.println(answer);
    }
}
