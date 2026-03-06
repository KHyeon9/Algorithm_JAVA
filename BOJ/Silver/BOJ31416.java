import java.io.*;
import java.util.*;

public class BOJ31416 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t_a = Integer.parseInt(st.nextToken());
            int t_b = Integer.parseInt(st.nextToken());
            int v_a = Integer.parseInt(st.nextToken());
            int v_b = Integer.parseInt(st.nextToken());

            int bTestTime = t_b * v_b;
            int aTestTime = t_a * v_a;
            if (aTestTime > bTestTime) {
                // 도훈이 오기전 상훈이가 끈낸 테스트 갯수
                int doneATest = bTestTime / t_a;
                int sanghunTime = doneATest * t_a;
                int dohunTime = bTestTime;
                // 남은 과제의 갯수
                int remainA = v_a - doneATest;
                // 남은 과제 수행
                for (int i = 0; i < remainA; i++) {
                    if (sanghunTime + t_a <= dohunTime + t_a) {
                        sanghunTime += t_a;
                    } else {
                        dohunTime += t_a;
                    }
                }
                System.out.println(Math.max(sanghunTime, dohunTime));
            } else {
                // b가 더 크거나 같은 경우는 같이 작업하는 경우가 없음 
                System.out.println(bTestTime);
            }
        }

        br.close();
    }
}
