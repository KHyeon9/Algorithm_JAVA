import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ34426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 전체 구간 수
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int routeCount = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 최소 시간 저장
            double minTime = Double.MAX_VALUE;
            // 가장 빠른 경로의 인덱스
            int bestIdx = 1;

            for (int j = 1; j <= routeCount; j++) {
                double speed = Double.parseDouble(st.nextToken());
                double distance = Double.parseDouble(st.nextToken());
                // 이동 시간 계산
                double time = distance / speed;
                // 더 짧은 시간이면 갱신
                if (time < minTime) {
                    minTime = time;
                    bestIdx = j;
                }
            }
            System.out.println(bestIdx);
        }
    }
}
