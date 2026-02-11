import java.io.*;
import java.util.ArrayList;

public class BOJ2668 {
    static int numCnt;
    static int[] nums;
    static boolean[] visited;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        numCnt = Integer.parseInt(br.readLine());
        // 숫자 받기
        nums = new int[numCnt + 1];
        for (int i = 1; i <= numCnt; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        // 상태를 저장할 리스트 셋팅
        for (int i = 1; i <= numCnt; i++) {
            // 자기 자신으로 돌아올 수 있는지 확인
            visited = new boolean[numCnt + 1];
            numSelect(i, i);
        }
        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (int num : answer) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
        br.readLine();
    }

    private static void numSelect(int now, int target) {
        visited[now] = true;

        int next = nums[now];
        // 다음이 처음 시작점인 target이면 추가
        if (next == target) {
            answer.add(target);
        }
        // target이 아니지만 방문하지 않으면 DFS
        if (!visited[next]) {
            numSelect(next, target);
        }
    }
}
