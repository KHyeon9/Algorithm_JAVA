import java.io.*;
import java.util.*;

public class BOJ2304 {
    static int[] storage = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int maxPos = 0, maxHeight = 0;
        int startPos = 1001;
        int endPos = 0;
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            // 높이 저장
            storage[pos] = height;
            // 최대 높이 및 위치 저장
            if (maxHeight < height) {
                maxPos = pos;
                maxHeight = height;
            }
            // 시작점과 종료 시점 저장
            startPos = Math.min(startPos, pos);
            endPos = Math.max(endPos, pos);
        }
        br.close();

        int answer = 0;
        // 왼쪽 구역 구하기
        int leftMax = 0;
        for (int i = startPos; i < maxPos; i++) {
            leftMax = Math.max(leftMax, storage[i]);
            answer += leftMax;
        }
        // 오른쪽 구역 구하기
        int rightMax = 0;
        for (int i = endPos; i > maxPos; i--) {
            rightMax = Math.max(rightMax, storage[i]);
            answer += rightMax;
        }
        // 최고점 부분 넓이 추가
        answer += maxHeight;

        System.out.println(answer);
    }
}
