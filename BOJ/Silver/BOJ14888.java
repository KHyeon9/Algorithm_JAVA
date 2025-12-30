import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int[] nums;
    static int[] calcCnt = new int[4];
    static int minNum = Integer.MAX_VALUE, maxNum = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        // 주어진 숫자로 초기화
        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // 연잔자 갯수 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calcCnt[i] = Integer.parseInt(st.nextToken());
        }
        // 백트랙킹으로 계산
        calcMinAndMaxNum(0, 1, nums[0], n);
        // 출력
        System.out.println(maxNum);
        System.out.println(minNum);
    }

    private static void calcMinAndMaxNum(int idx, int depth, int nowNum, int size) {
        // 깊이와 사이즈가 같으면 최소, 최대값 저장
        if (depth == size) {
            maxNum = Math.max(maxNum, nowNum);
            minNum = Math.min(minNum, nowNum);
            return;
        }
        // 연산자 4개이므로 4만큼 반복
        for (int i = 0; i < 4; i++) {
            // 1개 이상 연산자 갯수가 존재할 경우에만
            if (calcCnt[i] > 0) {
                // 연산자 사용
                calcCnt[i]--;
                // 연산자에 따른 현재 값과 다음 값 계산
                int calcNum = calcOperation(nowNum, idx + 1, i);
                // 백트랙킹
                calcMinAndMaxNum(idx + 1, depth + 1, calcNum, size);
                // 연산자 되돌리기
                calcCnt[i]++;
            }
        }
    }
    // 연산자 저장 위치에 따른 연산 결과 반환
    private static int calcOperation(int nowNum, int idx, int op) {
        switch (op) {
            case 0: return nowNum + nums[idx];
            case 1: return nowNum - nums[idx];
            case 2: return nowNum * nums[idx];
            default: return nowNum / nums[idx];
        }
    }
}
