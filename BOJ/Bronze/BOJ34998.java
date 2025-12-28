import java.io.*;
import java.util.*;

public class BOJ34998 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int addCnt = Integer.parseInt(br.readLine());
            String[] calc = br.readLine().split(" ");
            int total = 0;
            boolean isMany = false;

            for (String str : calc) {
                // +는 넘어감
                if (str.equals("+")) {
                    continue;
                }
                // !이 하나라도 나오면 초과이므로 flag 변경 후 탈출
                if (str.equals("!")) {
                    isMany = true;
                    break;
                }
                total += Integer.parseInt(str);
            }
            // 9보다 크면 flag 변경
            if (total > 9) isMany = true;
            System.out.println(isMany ? "!" : total);
        }
    }
}
