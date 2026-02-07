import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int checkCnt = Integer.parseInt(st.nextToken());
        int inputCnt = Integer.parseInt(st.nextToken());

        String[] checkList = new String[checkCnt];
        for (int i = 0; i < checkCnt; i++) {
            checkList[i] = br.readLine();
        }
        // 정렬
        Arrays.sort(checkList);
        // 찾기
        int answer = 0;
        for (int i = 0; i < inputCnt; i++) {
            String start = br.readLine();
            if (isStartsWith(checkList, start)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
    // 이분 탐색
    private static boolean isStartsWith(String[] check, String start) {
        int left = 0, right = check.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            String curr = check[middle];
            if (curr.startsWith(start)) {
                return true;
            } else {
                // 해당 단어보다 작은 단어면 right 변경
                if (curr.compareTo(start) > 0) {
                    right = middle - 1;
                } else {
                    // 해당 단어보다 큰 단어면 left 변경 
                    left = middle + 1;
                }
            }
        }
        return false;
    }
}
