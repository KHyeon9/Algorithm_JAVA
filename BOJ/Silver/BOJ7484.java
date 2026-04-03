import java.io.*;
import java.util.*;

public class BOJ7484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int gameCnt = Integer.parseInt(br.readLine());

        for (int game = 0; game < gameCnt; game++) {
            // 볼링 넘어뜨린 핀 갯수 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> downPinCnts = new ArrayList<>();
            while (st.hasMoreTokens()) {
                downPinCnts.add(Integer.parseInt(st.nextToken()));
            }
            // 점수 계산
            int idx = 0;
            int score = 0;
            for (int frame = 1; frame <= 10; frame++) {
                int downPinCnt = downPinCnts.get(idx);
                // 스트라이크인 경우
                if (downPinCnt == 10) {
                    score += 10 + downPinCnts.get(idx + 1) + downPinCnts.get(idx + 2);
                    idx++;
                } else {
                    // 스트라이크가 아닌 경우
                    int sumDownCnt = downPinCnt + downPinCnts.get(idx + 1);
                    // 스페어 아닌 경우 처리
                    if (sumDownCnt < 10) {
                        score += sumDownCnt;
                    } else {
                        // 스페어 처리
                        score += sumDownCnt + downPinCnts.get(idx + 2);
                    }
                    // 2개의 핀 갯수 사용으로 +2
                    idx += 2;
                }
            }
            System.out.println(score);
        }
    }
}
