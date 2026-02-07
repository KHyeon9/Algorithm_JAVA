import java.io.*;
import java.util.*;

public class BOJ9329 {
    static class PrizeInfo {
        ArrayList<Integer> needSticker;
        int prizeMoney;

        public PrizeInfo() {
            this.needSticker = new ArrayList<>();
            this.prizeMoney = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int prizeCnt = Integer.parseInt(st.nextToken());
            int stickerType = Integer.parseInt(st.nextToken());
            // 각 상금 별 필요 갯수 받기
            PrizeInfo[] prizes = new PrizeInfo[prizeCnt];
            for (int prize = 0; prize < prizeCnt; prize++) {
                st = new StringTokenizer(br.readLine());
                int stickerCnt = Integer.parseInt(st.nextToken());
                PrizeInfo prizeInfo = new PrizeInfo();
                for (int sticker = 0; sticker < stickerCnt; sticker++) {
                    prizeInfo.needSticker.add(Integer.parseInt(st.nextToken()));
                }
                prizeInfo.prizeMoney = Integer.parseInt(st.nextToken());
                prizes[prize] = prizeInfo;
            }
            // 스티커 타입 별 갯수
            st = new StringTokenizer(br.readLine());
            int[] stickerTypeCnt = new int[stickerType + 1];
            for (int i = 1; i <= stickerType; i++) {
                stickerTypeCnt[i] = Integer.parseInt(st.nextToken());
            }
            // 결과 계산
            int answer = 0;
            for (PrizeInfo info : prizes) {
                // 만들 수 있는 갯수는 최소 갯수임
                int minCnt = Integer.MAX_VALUE;
                for (int needType : info.needSticker) {
                    minCnt = Math.min(minCnt, stickerTypeCnt[needType]);
                }
                answer += minCnt * info.prizeMoney;
            }
            System.out.println(answer);
        }
    }
}
