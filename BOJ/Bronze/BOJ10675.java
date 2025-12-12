import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // 이용 금액 및 정류장 갯수 받기
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int cityCnt = Integer.parseInt(st.nextToken());

            // 정류장 순서 입력받기
            st = new StringTokenizer(br.readLine());
            boolean flag = false;

            for (int j = 0; j < cityCnt; j++) {
                int cityNums = Integer.parseInt(st.nextToken());
                // 현재 정류장이 타는 위치인가
                if (cityNums == start) {
                    flag = true;
                }
                // 탑승을 한 후 가고자한 역에 도착했는가
                if (flag && cityNums == end) {
                    res = Math.min(res, cost);
                }
            }
        }
        // 값이 바뀌지 않으면 도착 못한것 이므로 -1 출력
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
}
