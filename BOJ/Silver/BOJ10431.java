import java.io.*;
import java.util.*;

public class BOJ10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int testNum = Integer.parseInt(st.nextToken());
            int[] childHeight = new int[20];
            int changeCnt = 0;
            for (int i = 0; i < 20; i++) {
                int nowChild = Integer.parseInt(st.nextToken());;
                int targetIdx = -1;
                // 내가 가야하는 자리 찾기
                for (int j = 0; j < i; j++) {
                    if (childHeight[j] > nowChild) {
                        targetIdx = j;
                        break;
                    }
                }
                // 내가 가장 큰 경우
                if (targetIdx == -1) {
                    childHeight[i] = nowChild;
                } else {
                    // 작은 값이 존재하는 경우
                    for (int j = i - 1; j >= targetIdx; j--) {
                        // 뒤에서 부터 1칸씩 뒤로 밀기
                        childHeight[j + 1] = childHeight[j];
                        // 이동 횟수 추가
                        changeCnt++;
                    }
                    // 내가 가야하는 자리에 저장
                    childHeight[targetIdx] = nowChild;
                }
            }

            System.out.println(testNum + " " + changeCnt);
        }
    }
}
