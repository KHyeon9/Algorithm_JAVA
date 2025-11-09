import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17136 {
    static int[][] paper = new int[10][10];
    static int[] colorPaperCnt = {0, 5, 5, 5, 5, 5};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 입력
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // backtracking 함수 실행
        backtracking(0, 0, 0);
        // 출력
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void backtracking(int x, int y, int useCnt) {
        // 최소값 보다 현제 사용한 색종이 양이 많은 경우 뒤로가기 (가지치기)
        if (answer <= useCnt) return;
        // y가 10인 경우는 종이의 모든 값 확인이 끝났으므로 결과값 확인
        if (y == 10) {
            answer = Math.min(answer, useCnt);
            return;
        }
        // x가 10인 경우 행이 끝났으므로 다음 줄로 넘어감
        if (x == 10) {
            backtracking(0, y + 1, useCnt);
            return;
        }
        // 덥어야 하는 부분인지 확인
        if (paper[y][x] == 1) {
            for (int size = 5; size > 0; size--) {
                if (colorPaperCnt[size] > 0 && check(x, y, size)) {
                    // 색종이 사용
                    colorPaperCnt[size]--;
                    // 색종이 덮은 부분 0으로 채우기
                    cover(x, y, size, 0);
                    backtracking(x + 1, y, useCnt + 1);
                    // 색종이를 다시 빼므로 1로 채우기
                    cover(x, y, size, 1);
                    // 이전으로 돌아왔으므로 다시 색종이 + 1
                    colorPaperCnt[size]++;
                }
            }
        } else {
            backtracking(x + 1, y, useCnt);
        }
    }
    // 색종이를 덮는 메소드
    private static void cover(int x, int y, int size, int val) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                paper[i][j] = val;
            }
        }
    }
    // 색종이가 덮을 수 있는지 확인하는 메소드
    private static boolean check(int x, int y, int size) {
        // 해당 색종이가 덮을 공간보다 작은지 확인
        if (x + size > 10 || y + size > 10) return false;
        // 색종이 사이즈 만큼 덮을 수 있는지 확인
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (paper[i][j] != 1) return false;
            }
        }
        return true;
    }
}
