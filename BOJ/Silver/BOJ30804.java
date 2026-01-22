import java.io.*;
import java.util.*;

public class BOJ30804 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        // 과일 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] fruits = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }
        // 과일 갯수를 저장할 map
        Map<Integer, Integer> fruitsCnt = new HashMap<>();
        // 2개의 포인터로 최대 갯수 계싼
        int answer = 0;
        int left = 0;
        for (int right = 0; right < cnt; right++) {
            // 과일 갯수 추가
            fruitsCnt.put(fruits[right], fruitsCnt.getOrDefault(fruits[right], 0) + 1);
            // 과일 종류가 2개 이상인 경우
            while (fruitsCnt.size() > 2) {
                int leftFruit = fruits[left];
                // 2개 이하가 될때까지 왼쪽 포인터를 움직이며 제거
                Integer leftFruitCnt = fruitsCnt.get(leftFruit);
                // 없는 값인 경우 넘어가기
                if (leftFruitCnt == null) continue;
                // 1개인 경우 제거
                if (leftFruitCnt == 1) {
                    fruitsCnt.remove(leftFruit);
                } else {
                    // 1개 초과면 -1
                    fruitsCnt.put(leftFruit, leftFruitCnt - 1);
                }
                left++;
            }
            // 어차피 갯수는 오른쪽에서 왼쪽 위치를 빼고 +1한 값
            answer = Math.max(answer, right - left + 1);
        }
        System.out.println(answer);
    }
}
