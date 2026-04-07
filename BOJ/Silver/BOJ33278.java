import java.io.*;
import java.util.*;

public class BOJ33278 {
    static class Stick{
        int pos;
        long height;

        public Stick (int pos, long height) {
            this.pos = pos;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int stickCnt = Integer.parseInt(st.nextToken());
        long inclination = Long.parseLong(st.nextToken());

        Stick[] sticks = new Stick[stickCnt];
        for (int i = 0; i < stickCnt; i++) {
             st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            long len = Long.parseLong(st.nextToken());
            sticks[i] = new Stick(pos, len);
        }
        // 위치 정보를 기반으로 정렬
        Arrays.sort(sticks, Comparator.comparing(o -> o.pos));
        // 나무에 그림자 지는 길이 구하기
        long sum = 0;
        long maxShadow = Long.MIN_VALUE;
        for (int i = 0; i < stickCnt; i++) {
            Stick currStick = sticks[i];
            // 첫수는 비교할 막대기가 없으므로 이후 부터 검사
            if (i > 0) {
                // 최대 길이의 그림자의 길이가 영향 미치는지 확인
                long shadowHeight = maxShadow - (inclination * currStick.pos);
                // 최대 그림자가 해당 막대기에 그림자기 지면 추가
                if (shadowHeight > 0) {
                    sum += Math.min(currStick.height, shadowHeight);
                }
            }
            // 현재 가장큰 그림자 비교 및 저장
            long currShadow = currStick.height + inclination * currStick.pos;
            maxShadow = Math.max(maxShadow, currShadow);
        }
        System.out.println(sum);
    }
}
