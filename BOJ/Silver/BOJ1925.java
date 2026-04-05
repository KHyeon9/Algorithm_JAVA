import java.io.*;
import java.util.*;

public class BOJ1925 {
    static class Pos {
        long x, y;

        public Pos(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        Pos[] tri = new Pos[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            tri[i] = new Pos(x, y);
        }
        
        if (!isTriangle(tri)) {
            System.out.println("X");
        } else {
            long a = getCalcPos(tri[0], tri[1]);
            long b = getCalcPos(tri[1], tri[2]);
            long c = getCalcPos(tri[2], tri[0]);
            // 각도 계산을 위한 정렬
            long[] lenArr = {a, b, c};
            Arrays.sort(lenArr);
            // 삼각형 종류 확인
            if (a == b && b == c) {
                // 정삼각형의 경우
                System.out.println("JungTriangle");
            } else if (a == b || b == c || c == a) {
                // 이등변 삼각형의 경우
                if (lenArr[0] + lenArr[1] < lenArr[2]) {
                    // 둔각
                    System.out.println("Dunkak2Triangle");
                } else if (lenArr[0] + lenArr[1] == lenArr[2]) {
                    // 직각
                    System.out.println("Jikkak2Triangle");
                } else {
                    // 예각
                    System.out.println("Yeahkak2Triangle");
                }
            } else {
                // 이등변이나 정삼각형이 아닌 경우
                if (lenArr[0] + lenArr[1] < lenArr[2]) {
                    // 둔각
                    System.out.println("DunkakTriangle");
                } else if (lenArr[0] + lenArr[1] == lenArr[2]) {
                    // 직각
                    System.out.println("JikkakTriangle");
                } else {
                    // 예각
                    System.out.println("YeahkakTriangle");
                }
            }
        }
    }

    private static long getCalcPos(Pos p1, Pos p2) {
        long dx = Math.abs(p1.x - p2.x);
        long dy = Math.abs(p1.y - p2.y);
        return dx * dx + dy * dy;
    }

    private static boolean isTriangle(Pos[] t) {
        // 기울기 공식으로 확인
        long res = (t[1].y - t[0].y) * (t[2].x - t[1].x)
                - (t[2].y - t[1].y) * (t[1].x - t[0].x);
        return res != 0;
    }
}
