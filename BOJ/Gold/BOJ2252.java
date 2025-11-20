import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] answer = new int[n];

        // 노드 초기화
        List<Integer>[] nodes = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new ArrayList<>();
        }
        // 위상 크기 지정
        int[] phases = new int[n + 1];
        // 입력받은 노드 마다 연관 노드 추가
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int student1 = Integer.parseInt(st.nextToken());
            int student2 = Integer.parseInt(st.nextToken());
            // student1이 student2보다 큼
            nodes[student1].add(student2);
            // 진입 차수 배열 셋팅
            phases[student2]++;
        }
        // 큐에 위상이 0인 값들 담기
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (phases[i] == 0) queue.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        // 위상인 0인 값들의 연결 노트 확인 및 큐가 빌때까지 반복        
        while (!queue.isEmpty()) {
            // 검사할 노드 큐에서 꺼내기
            int now = queue.poll();
            // 스트링 빌더로 문자열 생성
            sb.append(now).append(" ");
            // 현재 노드와 관련된 노드 위상 변경 및 0인 경우 큐에 추가
            for (int next : nodes[now]) {
                phases[next]--;
                if (phases[next] == 0) queue.offer(next);
            }
        }

        System.out.println(sb);
    }

}
