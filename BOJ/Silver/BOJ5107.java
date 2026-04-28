import java.io.*;
import java.util.*;

public class BOJ5107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int testNum = 1;
        while (true) {
            int cnt = Integer.parseInt(br.readLine());
            // 0이면 탈출
            if (cnt == 0) break;
            // 각 마니또 정보를 이름으로 연결해 저장
            Map<String, String> manito = new HashMap<>();
            for (int i = 0; i < cnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();
                manito.put(name1, name2);
            }
            // 마니또 체인 구하기
            int chainCnt = 0;
            Set<String> visited = new HashSet<>();
            for (String name : manito.keySet()) {
                // 해당 이름이 포함되지 않은 경우
                if (!visited.contains(name)) {
                    chainCnt++;
                    String currName = name;
                    while (!visited.contains(currName)) {
                        visited.add(currName);
                        currName = manito.get(currName);
                    }
                }
            }
            System.out.println(testNum + " " + chainCnt);
            testNum++;
        }
        br.close();
    }
}
