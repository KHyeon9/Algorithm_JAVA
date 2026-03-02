import java.io.*;
import java.util.*;

public class BOJ31066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int studentCnt = Integer.parseInt(st.nextToken());
            int umbrellaCnt = Integer.parseInt(st.nextToken());
            int usingUmbrella = Integer.parseInt(st.nextToken());
            // 학생수가 1이 아닌데 우산이 1개고 1명만 사용 가능하면 왕복만 반복해서 불가능
            if (studentCnt != 1 && umbrellaCnt == 1 && usingUmbrella == 1) {
                System.out.println(-1);
            } else {
                int count = 0;
                while (true) {
                    studentCnt -= umbrellaCnt * usingUmbrella;
                    count++;
                    // 남아있는 사람 없으면 탈출
                    if (studentCnt <= 0) {
                        break;
                    }
                    // 우산가지고 오는 경우도 +1
                    studentCnt += 1;
                    count++;
                }
                System.out.println(count);
            }
            br.close();
        }
    }
}
