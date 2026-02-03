import java.io.*;
import java.util.*;

public class BOJ9255 {
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int personCnt = Integer.parseInt(st.nextToken());
            int connectCnt = Integer.parseInt(st.nextToken());
            // visited 셋팅
            visited = new boolean[personCnt + 1];
            // 관계 리스트 셋팅
            ArrayList<ArrayList<Integer>> personConnect = new ArrayList<>();
            for (int i = 0; i <= personCnt; i++) {
                personConnect.add(new ArrayList<>());
            }
            // 관계 셋팅
            for (int conn = 0; conn < connectCnt; conn++) {
                st = new StringTokenizer(br.readLine());
                int person1 = Integer.parseInt(st.nextToken());
                int person2 = Integer.parseInt(st.nextToken());
                // 양방향 셋팅
                personConnect.get(person1).add(person2);
                personConnect.get(person2).add(person1);
            }
            // 의심 인물
            int target = Integer.parseInt(br.readLine());
            ArrayList<Integer> answer = getConnectPerson(personConnect, target);
            // 출력
            sb.append(String.format("Data Set %d:\n", test));
            for (int person : answer) {
                sb.append(person).append(" ");
            }
            sb.append("\n\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static ArrayList<Integer> getConnectPerson(ArrayList<ArrayList<Integer>> personConnect, int target) {
        ArrayList<Integer> answer = new ArrayList<>();
        visited[target] = true;
        // 탐색
        for (int nextPerson : personConnect.get(target)) {
            // 방문하지 않은 경우
            if (!visited[nextPerson]) {
                visited[nextPerson] = true;
                // 결과에 추가 및 덱에 넣기
                answer.add(nextPerson);
            }
        }

        // 결과 오름차순 정렬
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
