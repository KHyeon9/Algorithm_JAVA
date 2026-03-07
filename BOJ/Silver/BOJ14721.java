import java.io.*;
import java.util.*;

public class BOJ14721 {
    static class StudyFunc {
        int x, y;

        public StudyFunc(int x, int y) {
            this.x = x;
            this.y = y;
        }
        // RSS 계산을 위한 메소드
        public long calc(int a, int b) {
            long base = this.y - (a * x + b);
            return base * base;
        }
    }
    static StudyFunc[] studyInfos;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int dataCnt = Integer.parseInt(br.readLine());

        studyInfos = new StudyFunc[dataCnt];
        for (int i = 0; i < dataCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            studyInfos[i] = new StudyFunc(x, y);
        }
        br.close();

        long minRSS = Long.MAX_VALUE;
        int resA = 0, resB = 0;
        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                // 현재 RSS 계산
                long nowRSS = 0;
                for (int i = 0; i < dataCnt; i++) {
                    nowRSS += studyInfos[i].calc(a, b);
                }
                // 현재 최소 RSS보다 작으면 변경 및 A, B 저장
                if (minRSS > nowRSS) {
                    minRSS = nowRSS;
                    resA = a;
                    resB = b;
                }
            }
        }
        System.out.println(resA + " " + resB);
    }
}
