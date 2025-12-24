import java.io.*;
import java.util.*;

public class BOJ1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> numsMap = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            numsMap.add(num);
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int checkNum = Integer.parseInt(st.nextToken());
            // numsMap이 있는 경우 삭제 및 원소 갯수 감소
            if (numsMap.contains(checkNum)) {
                numsMap.remove(checkNum);
                continue;
            }
            cnt++;
        }

        System.out.println(numsMap.size() + cnt);
        br.close();
    }
}
