import java.io.*;
import java.util.*;

public class BOJ11971 {
    static class LengthAndSpeed {
        int dist, speed;

        public LengthAndSpeed(int dist, int speed) {
            this.dist = dist;
            this.speed = speed;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int roadCnt = Integer.parseInt(st.nextToken());
        int driveCnt = Integer.parseInt(st.nextToken());

        LengthAndSpeed[] roadInfo = new LengthAndSpeed[roadCnt];
        int sumDist = 0;
        for (int i = 0; i < roadCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            sumDist += dist;
            roadInfo[i] = new LengthAndSpeed(sumDist, speed);
        }

        LengthAndSpeed[] driveInfo = new LengthAndSpeed[driveCnt];
        sumDist = 0;
        for (int i = 0; i < driveCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            sumDist += dist;
            driveInfo[i] = new LengthAndSpeed(sumDist, speed);
        }

        int roadIdx = 0, diveIdx = 0;
        int answer = 0;
        for (int dist = 1; dist <= 100; dist++) {
            // 현재 거리가 넘거간 경우 index 증가
            if (dist > roadInfo[roadIdx].dist) {
                roadIdx++;
            }
            if (dist > driveInfo[diveIdx].dist) {
                diveIdx++;
            }
            // 속도 위반의 경우 값 계산 
            int roadSpeed = roadInfo[roadIdx].speed;
            int driveSpeed = driveInfo[diveIdx].speed;
            if (roadSpeed < driveSpeed) {
                answer = Math.max(driveSpeed - roadSpeed, answer);
            }
        }
        System.out.println(answer);
    }
}
