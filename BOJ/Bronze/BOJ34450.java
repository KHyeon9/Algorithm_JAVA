import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ34450 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] nums = new boolean[n + p];

        for (int i = 0; i < n - 1; i++) {
            int idx = Integer.parseInt(st.nextToken());
            nums[idx] = true;
        }

        for (int i = p; i < n + p; i++) {
            if (!nums[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}
