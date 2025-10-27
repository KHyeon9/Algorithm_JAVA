import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ34459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int linit = 5;
            int cnt = 1;

            while (linit < n) {
                linit *= 5;
                cnt++;
            }

            System.out.println(cnt == 1 ? "MIT time" : String.format("MIT^%d time", cnt));
        }
    }
}
