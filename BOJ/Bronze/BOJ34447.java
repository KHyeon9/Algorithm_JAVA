import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ34447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String num = st.nextToken();
            StringBuilder sb = new StringBuilder();
            // 각 자리수에 k를 더하고 10이 넘으면 10의로 나눈 나머지로 변경
            for (char c : num.toCharArray()) {
                int tempNum = (c - '0' + k) % 10;
                sb.append(tempNum);
            }
            
            System.out.println(sb.toString());
        }
    }
}
