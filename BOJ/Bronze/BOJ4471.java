import java.io.*;
import java.util.*;

public class BOJ4471 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            String startName = br.readLine();
            st = new StringTokenizer(br.readLine());
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double z1 = Double.parseDouble(st.nextToken());
            String targetName = br.readLine();
            st = new StringTokenizer(br.readLine());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double z2 = Double.parseDouble(st.nextToken());
            // 거리 계산
            double totalDist = Math.sqrt(
                    powPos(x1, x2) +
                    powPos(y1, y2) +
                    powPos(z1, z2)
            );
            // 출력
            System.out.println(
                    String.format(
                            "%s to %s: %.2f",
                            startName, targetName,
                            totalDist
                    )
            );
        }
        br.close();
    }

    private static double powPos(double n1, double n2) {
        double gap = n1 - n2;
        return gap * gap;
    }
}
