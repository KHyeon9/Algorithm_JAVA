import java.util.*;
import java.io.*;

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cableCnt = Integer.parseInt(st.nextToken());
        int needCableCnt = Integer.parseInt(st.nextToken());
        // 최대 길이를 구하면서 배열에 저장
        int maxLangth = 0;
        int[] lanCables = new int[cableCnt];
        for (int i = 0; i < cableCnt; i++) {
            lanCables[i] = Integer.parseInt(br.readLine());
            maxLangth = Math.max(maxLangth, lanCables[i]);
        }
        // 출력
        System.out.println(getMaxCableLength(maxLangth, needCableCnt , lanCables));
    }

    private static long getMaxCableLength(int maxLangth, int needCableCnt, int[] lanCables) {
        long answer = 0;
        long left = 1, right = maxLangth;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (getCableCnt(mid, lanCables) < needCableCnt) {
                right = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
        }
        return answer;
    }

    private static int getCableCnt(long length, int[] lanCables) {
        int cnt = 0;
        for (int cable : lanCables) {
            cnt += (int) (cable / length);
        }
        return cnt;
    }
}
