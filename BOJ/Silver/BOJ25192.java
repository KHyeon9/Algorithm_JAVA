import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> setName = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            // enter시 set 초기화 및 인사 횟수 추가
            if (line.equals("ENTER")) {
                answer += setName.size();
                setName = new HashSet<>();
                continue;
            }
            setName.add(line);
        }
        // enter가 다시 안들어온 경우 인사 횟수 추가
        answer += setName.size();
        System.out.println(answer);
    }
}
