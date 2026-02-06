import java.io.*;
import java.util.*;

public class BOJ6811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int troutPoint = Integer.parseInt(br.readLine());
        int pikePoint = Integer.parseInt(br.readLine());
        int pickerelPoint = Integer.parseInt(br.readLine());
        int limit = Integer.parseInt(br.readLine());

        // 3개 종류만 있으므로 3중 for문
        int cnt = 0;
        for (int troutCnt = 0; troutCnt <= (limit / troutPoint); troutCnt++) {
            for (int pikeCnt = 0; pikeCnt <= (limit / pikePoint); pikeCnt++) {
                for (int pickerelCnt = 0; pickerelCnt <= (limit / pickerelPoint); pickerelCnt++) {
                    int sum = (troutPoint * troutCnt) + (pikePoint * pikeCnt) + (pickerelPoint * pickerelCnt);
                    // 제한 이하고 1개 이상 물고기를 잡은 경우
                    if (sum <= limit && (troutCnt + pikeCnt + pickerelCnt) > 0) {
                        System.out.println(
                                String.format(
                                        "%d Brown Trout, %d Northern Pike, %d Yellow Pickerel"
                                        , troutCnt, pikeCnt, pickerelCnt
                                )
                        );
                        cnt++;
                    }
                }
            }
        }
        System.out.println("Number of ways to catch fish: " + cnt);
        br.close();
    }
}
