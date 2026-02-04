import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ35247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        double temp = 0;
        long now = 1;

        while (n > now - 1) {
            temp++;
            now *= 2;
        }

        int answer = 1;
        while (answer < temp) {
            answer *= 2;
        }
        System.out.println(answer + (answer == 1 ? " bit" : " bits"));
    }
}
