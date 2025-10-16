import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ34364 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();
        int shift = 1;
        StringBuffer sb = new StringBuffer();

        for (char c : s.toCharArray()) {
            int decode = (c - 'A' + shift) % 26 + 'A';
            sb.append((char) decode);
            shift = (shift * 2) % 26;
        }

        System.out.println(sb);
    }
}
