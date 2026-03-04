import java.io.*;
import java.util.*;

public class BOJ1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] linePos = new int[n];
        for (int i = 0; i < n; i++) {
            linePos[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        // 계산 및 저장
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int pos = linePos[i];
            for (int j = 0; j < n; j++) {
                // 나보다 큰 앞에수 맞는지 확인
                if (answer[j] == 0) {
                    if (pos == 0) {
                        answer[j] = i + 1;
                        break;
                    }
                    pos--;
                }
            }
        }
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int h : answer) {
            sb.append(h).append(" ");
        }
        System.out.println(sb);
    }
}
