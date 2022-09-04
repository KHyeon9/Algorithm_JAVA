import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            String s = br.readLine();
            String r1 = String.valueOf(s.charAt(0));
            String r2 = String.valueOf(s.charAt(s.length()-1));

            System.out.println(r1 + r2);
        }
    }
}
