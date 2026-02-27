import java.io.*;
import java.util.*;

public class BOJ35202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int macCoin = Integer.parseInt(st.nextToken());
        int myCoin = Integer.parseInt(st.nextToken());
        // 계산 및 출력
        if (macCoin < myCoin) {
            System.out.println(macCoin + 1);
        } else if (macCoin == myCoin) {
            System.out.println(macCoin);
        } else {
            System.out.println(0);
        }
        br.close();
    }
}
