import java.util.*;
import java.io.*;

public class BOJ26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // set으로 중복 제거
        Set<String> dance = new HashSet<>();
        dance.add("ChongChong");
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name1 = st.nextToken();
            String name2 = st.nextToken();
            // 둘중 하나라도 무지개 댄스인 경우 둘다 추가
            if (dance.contains(name1)){
                dance.add(name2);
            } else if (dance.contains(name2)) {
                dance.add(name1);
            }
        }
        System.out.println(dance.size());
    }
}
