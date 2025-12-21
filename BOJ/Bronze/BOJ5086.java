import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if (n1 == 0 && n2 == 0) {
                break;
            }

            System.out.println(solution(n1, n2));
        }
    }

    private static String solution(int n1, int n2) {
        if (n2 % n1 == 0)
            return "factor";
        else if (n1 % n2 == 0)
            return "multiple";
        else
            return "neither";
    }
}