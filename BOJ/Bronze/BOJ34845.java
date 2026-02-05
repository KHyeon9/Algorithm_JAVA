import java.io.*;
import java.util.*;

public class BOJ34845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int targetAvg = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < cnt; i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        int addCnt = 0;
        while (true) {
            if (sum / (cnt + addCnt) >= targetAvg) {
                System.out.println(addCnt);
                break;
            }
            sum += 100;
            addCnt++;
        }
    }
}
