import java.io.*;
import java.util.*;

public class BOJ7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            // 이중 우선순위큐를 우선순위큐 2개로 하면 remove에 시간이 오래 걸림
            // 따라서 TreeMap을 통해 log(n)의 속도로 찾아서 해결
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int commCnt = Integer.parseInt(br.readLine());

            for (int n = 0; n < commCnt; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String comm = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (comm.equals("I")) {
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                } else {
                    // 비어있으면 넘어감
                    if (treeMap.isEmpty()) continue;
                    // 삭제일때 처리
                    int key;
                    if (num == 1) {
                        key = treeMap.lastKey();
                    } else {
                        key = treeMap.firstKey();
                    }
                    if (treeMap.get(key) == 1) {
                        treeMap.remove(key);
                    } else {
                        treeMap.put(key, treeMap.get(key) - 1);
                    }
                }
            }

            if (treeMap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            }
        }
    }
}
