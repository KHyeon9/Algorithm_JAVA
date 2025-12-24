import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // map으로 name과 index를 바꿔서 2번 저장
        Map<String, String> poketmon = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            poketmon.put(String.valueOf(i + 1), name);
            poketmon.put(name, String.valueOf(i + 1));
        }
        // 출력
        for (int i = 0; i < m; i++) {
            String ques = br.readLine();
            System.out.println(poketmon.get(ques));
        }
        
        br.close();
    }
}
